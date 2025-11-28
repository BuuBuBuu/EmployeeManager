1. Setup Env
2. Define model for every table and annotate them with @Entity
    - Add in the @Entity
    - Add in the @Id for primary key
    - Handle composite keys 
3. Complete the relationship mappings
4. Create DAOs?
5. Main driver class (Use try with resources to create the emf)
6. 



Notes:
- Entity Manager in the driver class?
- merge() can use for update but not necessary
- Check if need to use any BigDecimals BigDecimal.valueOf(123)
- Remember to em.close(); emf.close(); if never use the try with resource
- Create the emf and em in the Main function then pass it to the EmployeeDAO for example so that it can use that instance
  - Check the OnetoOne sample codes
- Owner side use @OneToOne and @JoinColumn, Inverse side to use @OneToOne(mappedBy="")
  - Check if need to do unidirectional or bidirectional
- One to Many use bidirectional usually
  - The owning side is the one with the * (employee)*-->1(Department)
  - Owner is employee which each one holds a Department object
  - Department will hold list of Employees
- Usually the updates are more complicated


Tips from angeline:
endpoint 1 easy
endpoint 2 return all 6 tables no DTOs is the hint depends on the Mapping
endpoint 3 require JPQL 1 DTO need
endpoint 4 POST Figure out scenarios that the DB can or cannot do. 1 DTO need
Body takes in JSON? Comment the code well so they can understand...
Use Jackson
Depending on what we use will depend on whether we need to code our own serializer and deserializer

endpoint 2 ++
should return Employee number and then titles deptemp deptmanager salaries of that employee etc nested JSON

endpoint 4
things to consider
Pass in a JSON
from date is needed
to date not needed just set to the 9999 or something that signifies current

salary pass in integer
Check if salary is same if same then leave it
If not same close out the old salary
Update new salary record in the salary

just pass in empNo

check if the emp is already a manager and then close their old managerial post with the end date
Then create the new manager record with the current.

check if new department is provided
then also have to check if its the same deptEmp if not we have to close it out.
then we have to start a new record in deptEmp for the new department that the employee has been transferred to


JPQL need to manually remove the sub tables
if you use stuff like .remove() method then no need to manually create (This is the api method from JPA)

