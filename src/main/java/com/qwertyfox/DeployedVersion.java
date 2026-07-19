import com.qwertyfox.demo.CalendarInitializer;
import com.qwertyfox.logic.ListRollOverDataModel;

static CalendarInitializer calendarInitializer = new CalendarInitializer("data/Dataset.txt");

static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
static Map<Integer, List<Integer>> yearMap = calendarInitializer.getYearMap();
static Map<Integer, Integer> mapWithListTotal = calendarInitializer.getMapWithListTotal();
static Map<Integer, Integer> cumulativeSumMap = calendarInitializer.getCumulativeSumMap();

void main() {
    String hookDateString = "13/04/1993"; // 1st Baishak 2050
    LocalDate hookDate = convertToLocalDate(hookDateString);

    ListRollOverDataModel listRollOverDataModel;

    boolean flag = false;

    Scanner scanner = new Scanner(System.in);
    IO.println("\nInsert date in proper day/month/year format and keep the date within data set's range.\n" +
            "You can also change conversion mid-application typing BS or AD in the prompt.\n");
    IO.println("Convert to AD or BS? :");

    while (true) {
        IO.print("Enter: ");
        String input = scanner.nextLine();
        try {

            if (input.toLowerCase().trim().contains("bs")) {
                IO.println("Converting to BS. Input AD date following the structure:");
                flag = true;
                continue;
            }

            if (input.toLowerCase().trim().contains("ad")) {

                flag = false;
                IO.println("Converting to AD. Input BS date following the structure:");
                continue;
            }

            if (!flag) {
                // Convert to AD
                int requiredJumps = findNumberOfDays(input);
                LocalDate BS_Date = LocalDate.of(1993, 4, 13).plusDays(requiredJumps - 1);
                IO.println(formatter.format(BS_Date) + " " + BS_Date.getDayOfWeek());
                IO.println("=====");
            } else {
                // Convert to BS
                LocalDate AD_Date = convertToLocalDate(input);
                long daysBetweenTest = hookDate.until(AD_Date, ChronoUnit.DAYS);
                listRollOverDataModel = findList((int) daysBetweenTest);

                String result = addingToDataStructure(listRollOverDataModel.getList(), listRollOverDataModel.getRemainingJumps());
                IO.println(result + " " + AD_Date.getDayOfWeek());
                IO.println("=====");
            }
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
    }
}

private static int findNumberOfDays(String date) {

    String split[] = date.trim().split("/");
    String listString = split[2];
    int listName = Integer.parseInt(listString);
    int index = Integer.parseInt(split[1]);
    int subElement = Integer.parseInt(split[0]);

    int cumulativeNumber = cumulativeSumMap.get(listName - 1);

    List<Integer> yearL = yearMap.get(listName);

    int listSum = 0;
    for (int i = 1; i <= index - 1; i++) {
        listSum += yearL.get(i);
    }

    int totalJumpsRequired = (listSum + cumulativeNumber + subElement);

    return totalJumpsRequired;
}

private static LocalDate convertToLocalDate(String date) {
    return LocalDate.parse(date, formatter);
}

private static String addingToDataStructure(List<Integer> list, int numberToAdd) {
    int elementSums = 0;
    int index = 1;
    int subElement;

    numberToAdd = numberToAdd + 1;
    for (index = 1; index < list.size(); index++) {
        elementSums += list.get(index);
        if (elementSums >= numberToAdd) {
            int value = list.get(index); // getting the sum value of the current index
            int valueBeforeCurrentIndex = (elementSums - value); // sum value before the current index value was added to the sum
            subElement = numberToAdd - valueBeforeCurrentIndex; // the remaining is the sub element

            // if the subElement value is 0, ie, the required sub element is at the end of the index then
            if (subElement == 0) {
                subElement = list.get(index - 1);
                index = index - 1;
            }
            return String.format("%02d/%02d/%s",subElement, index, list.get(0));
        }
    }
    return "";
}

private static ListRollOverDataModel findList(int numberToAdd) {

    int previousTotal = 0;

    for (Map.Entry<Integer, Integer> entry : mapWithListTotal.entrySet()) {
        int newTotal = previousTotal + entry.getValue();

        if (newTotal >= numberToAdd) {
            int leftOver = numberToAdd - previousTotal;
            return new ListRollOverDataModel(yearMap.get(entry.getKey()), leftOver);
        }
        previousTotal = newTotal;
    }

    return null;
}
