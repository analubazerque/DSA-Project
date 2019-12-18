package ImmigrationSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validations {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private String regex = "\\p{Upper}(\\p{Lower}+\\s?)";


    public void firstName(String firstName ) {
        if (firstName.matches(regex))
            return;
        else { System.out.println("Name is not valid. Please try again");
            String name = null;
            try {
                name = bf.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            firstName(name);
      }
    };

    // validate last name
    public void lastName(String lastName ) {
        if (lastName.matches(regex))
            return;
       else { System.out.println("Last Name is not valid. Please try again");
                String surname = null;
                try {
                    surname = bf.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                lastName(surname);

    }
}
    public boolean validateDate(String inputDate) throws IOException {
       if (inputDate.trim().equals("")) {
            return true;
        }
        else {
            SimpleDateFormat pattern = new SimpleDateFormat("dd/mm/yyyy");
            pattern.setLenient(false);
            try {
                //date format is valid
                Date date = pattern.parse(inputDate);
            }
            /* Date format is invalid */
            catch (ParseException e)  {
                System.out.println(inputDate+" is not a valid date format, try again");
                   String date = bf.readLine();
                   validateDate(date);
            }
            /* Return true if date format is valid */
            return true;
        }
    }

}

