package util;

import org.apache.poi.ss.usermodel.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Utility {

    //1. Method to generate a random FirstName
    public static String getRandomFirstName() {
        String[] names = {"Alice", "Bob", "Charlie", "Diana", "Emma", "Ethan", "Olivia", "Noah"};
        int randomIndex = new Random().nextInt(names.length);
        return names[randomIndex];
    }
    //2. Method to generate a random Email
    public static String generateRandomEmail() {
        String[] domains = {"gmail.com", "hotmail.com", "yahoo.com", "outlook.com"};
        int domainIndex = new Random().nextInt(domains.length);

        // Generate random username (alphanumeric + underscore)
        int usernameLength = 8;  // Adjust length as needed
        String username = generateRandomString(usernameLength, true);

        return username + "@" + domains[domainIndex];
    }

    //--------------------------------------------------------------------------------------------------------------------------
    //--------------------------------------------Generation Username------------------------------------------------------------------------------

    public static String generateUsername(int minLength, int maxLength) {
        // Create a random number generator
        Random random = new Random();

        // Define character sets for different parts of the username
        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseLetters = lowercaseLetters.toUpperCase();
        String digits = "0123456789";
        String allChars = lowercaseLetters + uppercaseLetters + digits;

        // Generate a random username length between minLength and maxLength
        int usernameLength = random.nextInt(maxLength - minLength + 1) + minLength;

        // Build the username character by character
        StringBuilder username = new StringBuilder();
        for (int i = 0; i < usernameLength; i++) {
            // Choose a random character set based on position
            String charSet;
            if (i == 0) {
                charSet = lowercaseLetters + uppercaseLetters; // Ensure first letter is alphabetic
            } else {
                charSet = allChars;
            }

            // Select a random character from the chosen set
            int charIndex = random.nextInt(charSet.length());
            char randomChar = charSet.charAt(charIndex);
            username.append(randomChar);
        }

        return username.toString();
    }
    private static String generateRandomString(int length, boolean allowNumbers) {
        String characters = "abcdefghijklmnopqrstuvwxyz";
        if (allowNumbers) {
            characters += "0123456789_";
        }
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }
    //--------------------------------------------------------------------------------------------------------------------------
    //--------------------------------------------Generation  random Password------------------------------------------------------------------------------

    //3. Method to generate a random Password
    public static String generatePassword(int length) {
        // Define characters to be used in the password
        String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
        String numericChars = "0123456789";
        String specialChars = "!@#$%^&*()-_=+";

        // Create a combined character pool
        String allChars = uppercaseChars + lowercaseChars + numericChars + specialChars;

        // Initialize random generator
        Random rand = new Random();

        // Generate the password ensuring at least one numeric character
        StringBuilder password = new StringBuilder();
        boolean hasNumeric = false; // Flag to track if we've added a numeric character
        for (int i = 0; i < length; i++) {
            // If we haven't added a numeric character yet, ensure we add one
            if (!hasNumeric) {
                // Choose a random numeric character
                int randomIndex = rand.nextInt(numericChars.length());
                char randomNumericChar = numericChars.charAt(randomIndex);
                password.append(randomNumericChar);
                hasNumeric = true; // Set the flag to true
            } else {
                // Choose a random character from the combined pool
                int randomIndex = rand.nextInt(allChars.length());
                char randomChar = allChars.charAt(randomIndex);
                password.append(randomChar);
            }
        }

        return password.toString();
    }
    ///


    // 4.Method to generate a random company name
    private static final String[] PREFIXES = {
            "Tech", "Global", "International", "Innovative", "Digital", "Creative", "Dynamic", "Strategic", "Smart", "NextGen"
    };
    // Array of possible company name suffixes
    private static final String[] SUFFIXES = {
            "Solutions", "Consulting", "Technologies", "Services", "Systems", "Enterprises", "Ventures", "Group", "Labs", "Corp"
    };
    // Method to generate a random company name
    public static String generateCompanyName() {
        Random rand = new Random();
        String prefix = PREFIXES[rand.nextInt(PREFIXES.length)];
        String suffix = SUFFIXES[rand.nextInt(SUFFIXES.length)];
        return prefix + " " + suffix;
    }

    //5. Method to generate a random Categories
    public static String getRandom_differentCategories() {
        String[] names = {"Computers ", "Electronics ", "Apparel ", "Digital downloads ", "Books ", "Jewelry ", "Gift Cards "};
        int randomIndex = new Random().nextInt(names.length);
        return names[randomIndex];
    }
    public static String getRandom_FirstThreeCategories() {
        String[] names = {"Computers ", "Electronics ", "Apparel "};
        int randomIndex = new Random().nextInt(names.length);
        return names[randomIndex];
    }
    public static String getRandom_ComputerItems() {
        String[] names = {"Desktops ", "Notebooks ", "Software "};
        int randomIndex = new Random().nextInt(names.length);
        return names[randomIndex];
    }
    public static String getRandom_ElectronicsItems() {
        String[] names = {"Camera & photo ", "Cell phones ", "Others "};
        int randomIndex = new Random().nextInt(names.length);
        return names[randomIndex];
    }
    public static String getRandom_ApparelItems() {
        String[] names = {"Shoes ", "Clothing ", "Accessories "};
        int randomIndex = new Random().nextInt(names.length);
        return names[randomIndex];
    }
    public static String getRandom_SubCategory_FromApparel_() {
        String[] names = {"Shoes ", "Clothing ", "Accessories "};
        int randomIndex = new Random().nextInt(names.length);
        return names[randomIndex];
    }
    public static void main(String[] args) {
        System.out.println(getRandom_differentCategories().trim()+" ");
    }


    public static int getRandomNumberBetween1and30() {
        Random random = new Random();
        // Generate a random integer between 0 (inclusive) and 30 (exclusive)
        int randomNumber = random.nextInt(30);
        // Add 1 to make the range inclusive of 1 and 30
        return randomNumber + 1;
    }
    public static String getRandomMonths() {
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        Random random = new Random();
        int randomIndex = random.nextInt(months.length); // Generate random index between 0 and 11
        return months[randomIndex];
    }
    public static int getRandomYearBetween1900And2021() {
        Random random = new Random();
        // Generate a random integer between 0 (inclusive) and 122 (exclusive)
        int randomYear = random.nextInt(122);
        // Add 1900 to get the year within the desired range (1900 - 2021)
        return randomYear + 1900;
    }

    public static String getSingleJsonData(String jsonFilePath,String jsonField) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();

        FileReader fileReader = new FileReader(jsonFilePath);
        Object obj = jsonParser.parse(fileReader);

        JSONObject jsonObject = (JSONObject) obj;
        return jsonObject.get(jsonField).toString();
    }
    public static String getExcelData(int rowNum,int colNum,String sheetName) {
//        XSSFWorkbook workBook;
//        XSSFSheet sheet;
//        String projectPath = System.getProperty("user.dir");
//        String cellData = null;
//        try {
//            workBook = new XSSFWorkbook(projectPath + "/src/test/resources/test_data/Address_Information.xlsx");
//            sheet = workBook.getSheet(SheetName);
//            cellData = sheet.getRow(RowNum).getCell(ColNum).getStringCellValue();
//
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//            System.out.println(e.getCause());
//            e.printStackTrace();
//        }
//        return cellData;

            String projectPath = System.getProperty("user.dir");
            String cellData = null;
            FileInputStream fis = null;
            Workbook workBook = null;

            try {
                fis = new FileInputStream(projectPath + "/src/test/resources/test_data/Address_Information.xlsx");
                workBook = WorkbookFactory.create(fis);
                Sheet sheet = workBook.getSheet(sheetName);
                Row row = sheet.getRow(rowNum);
                Cell cell = row.getCell(colNum);

                if (cell != null) {
                    // Handle different cell types
                    switch (cell.getCellType()) {
                        case STRING:
                            cellData = cell.getStringCellValue();
                            break;
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                cellData = cell.getDateCellValue().toString(); // Handle date type
                            } else {
                                // Handle numeric type (integer or double)
                                cellData = String.valueOf(cell.getNumericCellValue());
                            }
                            break;
                        case BOOLEAN:
                            cellData = String.valueOf(cell.getBooleanCellValue());
                            break;
                        case FORMULA:
                            // Handle formula if needed
                            cellData = cell.getCellFormula();
                            break;
                        case BLANK:
                            // Handle blank cells
                            cellData = "";
                            break;
                        default:
                            // Handle other types such as error or unknown
                            cellData = "Unsupported cell type";
                            break;
                    }
                }
            } catch (IOException e) {
                System.out.println("Error reading Excel file: " + e.getMessage());
                e.printStackTrace();
            } finally {
                try {
                    if (fis != null) {
                        fis.close();
                    }
                    if (workBook != null) {
                        workBook.close();
                    }
                } catch (IOException e) {
                    System.out.println("Error closing file streams: " + e.getMessage());
                    e.printStackTrace();
                }
            }
            return cellData;

    }
//--------------------------------------------------------------------------------------------
public static String generateRandom_EmployeeId(int length) {
    String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    StringBuilder id = new StringBuilder();
    Random random = new Random();

    for (int i = 0; i < length; i++) {
        int randomIndex = random.nextInt(characters.length());
        id.append(characters.charAt(randomIndex));
    }

    return id.toString();
}

    public static String getRandom_Contry() {
        String[] names = {"India", "United States", "Canada", "Australia", "New Zealand ", "Singapore"};
        int randomIndex = new Random().nextInt(names.length);
        return names[randomIndex];
    }
//---------------------------------------------------------------------------------------------------


    // TODO: delete screenshots
    public static void deleteFilesInFolder(String folderPath) {
        File folder = new File(folderPath);
        if (folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        boolean isDeleted = file.delete();
                        if (isDeleted) {
                            System.out.println("Deleted: " + file.getName());
                        } else {
                            System.out.println("Failed to delete: " + file.getName());
                        }
                    }
                }
            } else {
                System.out.println("The specified folder is empty or an error occurred.");
            }
        } else {
            System.out.println("The specified path is not a folder.");
        }
    }

    //--------------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------ Generation Random Address--------------------------------------------------------------------------
    // Generation Random Address
    private static final String[] STREET_NAMES = {
            "Main St", "High St", "Park Ave", "Maple St", "Oak St", "Pine St", "Cedar St", "Elm St", "Birch St", "Spruce St"
    };
    private static final String[] CITY_NAMES = {
            "Springfield", "Rivertown", "Lakeside", "Hilltop", "Pleasantville", "Greenfield", "Fairview", "Lincoln", "Franklin", "Clinton"
    };
    private static final String[] STATE_CODES = {
            "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA",
            "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD",
            "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ",
            "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC",
            "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"
    };
    private static final Random RANDOM = new Random();
    public static String generateRandomAddress() {
        int streetNumber = RANDOM.nextInt(9999) + 1;
        String streetName = STREET_NAMES[RANDOM.nextInt(STREET_NAMES.length)];
        String cityName = CITY_NAMES[RANDOM.nextInt(CITY_NAMES.length)];
        String stateCode = STATE_CODES[RANDOM.nextInt(STATE_CODES.length)];
        int zipCode = 10000 + RANDOM.nextInt(90000);

        return String.format("%d %s, %s, %s %05d", streetNumber, streetName, cityName, stateCode, zipCode);
    }

//    String randomAddress = generateRandomAddress();
    //--------------------------------------------------------------------------------------------------------------------------
    //----------------------------------------- Generation Random City---------------------------------------------------------------------------------

    private static final String[] CITIES = {
            "New York", "Los Angeles", "Chicago", "Houston", "Phoenix",
            "Philadelphia", "San Antonio", "San Diego", "Dallas", "San Jose",
            "Austin", "Jacksonville", "Fort Worth", "Columbus", "San Francisco",
            "Charlotte", "Indianapolis", "Seattle", "Denver", "Washington"
    };

    public static String generateRandomCity() {
        Random random = new Random();
        int index = random.nextInt(CITIES.length);
        return CITIES[index];
    }

//    String randomCity = generateRandomCity();
    //--------------------------------------------------------------------------------------------------------------------------
    //--------------------------------------------Generation Random State------------------------------------------------------------------------------
private static final String[] STATES = {
        "Alabama", "Alaska", "Arizona", "Arkansas", "California",
        "Colorado", "Connecticut", "Delaware", "Florida", "Georgia",
        "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa",
        "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland",
        "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri",
        "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey",
        "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio",
        "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina",
        "South Dakota", "Tennessee", "Texas", "Utah", "Vermont",
        "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"
};

    public static String generateRandomState() {
        Random random = new Random();
        int index = random.nextInt(STATES.length);
        return STATES[index];
    }

   //String randomState = generateRandomState();
//--------------------------------------------------------------------------------------------------------------------------
    //--------------------------------------------Generation Random ZipCode------------------------------------------------------------------------------

    public static String generateRandomZipCode() {
        Random random = new Random();
        int zipCode = random.nextInt(100000); // Generates a number between 0 and 99999
        return String.format("%05d", zipCode); // Formats the number to be 5 digits long
    }

//    String randomZipCode = generateRandomZipCode();


    //--------------------------------------------------------------------------------------------------------------------------
    //--------------------------------------------Generation Random Phone number------------------------------------------------------------------------------


    public static String generateRandomPhoneNumber() {
        Random random = new Random();

        // Generate area code (XXX) - 3 digits, first digit between 2 and 9
        int areaCode = random.nextInt(800) + 200;

        // Generate central office code (XXX) - 3 digits, first digit between 2 and 9
        int centralOfficeCode = random.nextInt(800) + 200;

        // Generate line number (XXXX) - 4 digits
        int lineNumber = random.nextInt(10000);

        // Format the phone number
        return String.format("(%03d) %03d-%04d", areaCode, centralOfficeCode, lineNumber);
    }
//String randomPhoneNumber = generateRandomPhoneNumber();

//--------------------------------------------------------------------------------------------------------------------------
    //--------------------------------------------Generation Random SSN Social Security Number ------------------------------------------------------------------------------

    public static String generateRandomSSN() {
        Random random = new Random();

        // Generate area number (AAA) - 3 digits, between 001 and 899, excluding 666
        int areaNumber;
        do {
            areaNumber = random.nextInt(899) + 1;
        } while (areaNumber == 666);

        // Generate group number (GG) - 2 digits, between 01 and 99
        int groupNumber = random.nextInt(99) + 1;

        // Generate serial number (SSSS) - 4 digits, between 0001 and 9999
        int serialNumber = random.nextInt(9999) + 1;

        // Format the SSN
        return String.format("%03d-%02d-%04d", areaNumber, groupNumber, serialNumber);
    }
//String randomSSN = generateRandomSSN();
//--------------------------------------------------------------------------------------------------------------------------
    //--------------------------------------------Generation Random Amount $$ -----------------------------------------------

    public static int generateRandomAmount(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

//--------------------------------------------------------------------------------------------------------------------------
    //--------------------------------------------write in file txt -----------------------------------------------
    public static void writeUsernameToFile( String filePath,String username) {
        BufferedWriter writer = null;
        try {
            // Create a BufferedWriter object to write to the file
            writer = new BufferedWriter(new FileWriter(filePath, true)); // 'true' to append to file
            writer.write(username);
            writer.newLine(); // Write a newline character
            System.out.println("Username written to file: " + username);
        } catch (IOException e) {
            System.err.println("IOException while writing to file: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close the writer to release system resources
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.err.println("IOException while closing writer: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

    public static boolean isUsernameDuplicate( String filePath,String username) {
        Set<String> usernames = new HashSet<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                if (!usernames.add(line)) {
                    System.out.println(username+" : the username is already in the set, it's a duplicate");
                    if (line.equals(username)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("IOException while reading from file: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.err.println("IOException while closing reader: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
        return false;
    }


}
