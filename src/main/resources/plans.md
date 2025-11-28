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
endpoint 3 require JPQL
endpoint 4 POST Figure out scenarios that the DB can or cannot do.
Body takes in JSON? Comment the code well so they can understand...
Use Jackson
Depending on what we use will depend on whether we need to code our own serializer and deserializer
