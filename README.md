In total 4 classes are made : Control , Data , Gui and ProbCalc.


Control:
The control class holds main.It is used to create a gui class and a data class aswell as organise the data
class by calling the readdata method found in the data class.



Data:
The data class itself is used to read through the data in csv format
and seperate it into seperate lists (Temp,Aches,Cough,throat,recently,corona).The probability of each
outcome is then found for example the probability of having a cough and also having the virus , or not 
having a sore throat and not having the virus etc.



ProbCalc:
This class is used to multiply values found in data together. The values which are multiplied together
depend on the users options in the GUI. The result is printed to system and is also returned to the GUI
so it can print it in the GUI.



GUI:
The GUI class presents a basic interface with 5 dropdown boxes (comboboxes) and a button for checking results.
Dropdown boxes are used to limit user input so there is less error checking needed.
The options chosen in the GUI affect the result shown. There is also a button which opens your default
browser and links to 	https://coronavirus.jhu.edu/map.html




Short Description:
The program uses naive bayes to attempt to predict the chance of a person having the corona virus based on
5 options. Naive bayes works by finding the probability of your chosen options and the chance of them resulting
in you having the virus and also the chance of them resulting in you not having the virus.
These 2 results are normalised and then presented to the user.



Additional Features:
I would've liked to add a file chooser so the user could select their own file.Currently the user could 
change the file if they wanted but it would have to be called "data.csv".
An option for the user to add an extra case through the GUI would also be a nice feature.
The user can add additional cases now but it must be done by adding information to the CSV file.
Finally the GUI itself looks fairly barebones and basic adding some design to it would also be nice.



