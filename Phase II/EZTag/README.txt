Jason Jensen
Carrie Dumit
Isabel Almaguer

To compile and run from command line navigate to the PhaseII/EZTag folder then enter:
javac eztag/*.java eztagui/*.java
java eztagui.EZTag

Selecting register will allow you to create a new account, the .ser file for this account is saved in PhaseII/accounts.  Verification of unique usernames will be implemented in the final version.

Selecting Login will allow you to access an existing account using the account number, username and password.  At this time the account number is required since the accounts are saved in the format account#.ser, searching and verification by username will be implemented in the final version.

Selecting Create Event will allow you to simulate input from the sensor array.  The RFID is the account number, the entrance and exit are integer, the direction is based on which is smaller.  Unique ID's for the entrances and exits will be implemented in the final version.

System will currently calculate and apply a charge based on the direction, current system time, and number of exits.

All passwords are encrypted using MD5 before being saved.
