# QC Questions on SQL

- What is a relational database?
 - Name some common RDBMS platforms/vendors
 - What is SQL?
 Structured Query Language - how we interact with relational databases, a scriptiong language for scripting "work" to be done. 
 - What are the sub-languages of SQL?
 - What keywords are associated with DML? Data manipulation language - CRUD on data
 - What keywords are associated with DDL? Data Definition language - define and modify scema, CREATE, ALTER, DROP
 - What keywords are associated with DCL? Data control language - permissions, users and groups
 - What keywords are associated with TCL? Transaction Control language - manage transactions - unit of work
 - What keywords are associated with DQL? Data query language - querying, selecting - how we read data
 - What is a result set?
 This is what comes back from a query, wehat you get when you select - rows and columns, basically a spreadsheet or table
 - What is normalization? - opinionation - the idea that there is a best way to do something, the closer you adhere to the "opinion" the better you can leverage the optimizations put in place. The more you deviate, the more you leave those optimizations behind. Normalization is are conceptual best practices for how to build your schema to make use of the optimizations in place in the database engine.
 - What are the normal forms, and to what level do we usually comply to?
   - 1st - data should be "granular" 
   - 2nd - we shouldn't have dependencies on part of the primary key
   - 3rd - we shouldn't have transitive partial dependencies on the primary key
 - What is multiplicity?
 This is the term for "relationship" between two tables based on foreign key references
 one-to-one, one-to-many, many-to-one
 - How to implement?
   - one-to-one - define a foreign key that points to a PK, FK should have the unique constraint
   - one-to-many - define a foreign key that points to a PK
   - many-to-many - dNeed a junction table - a third table that contains references to bother other tables, these aren't unique constrained
 - What is a primary key? - a key which can uniquely identify any row in the database - now days it's its own dedicated column which is implcitly UNIQUE and NOT NULL, and are the primary or "clustered" index
 - What is a natural key? a natural choice for primary key, data already part of the relation (table) that can be used as a PK
 - What is surrogate key? opposite of natural key, has nothing to do with the data in the relation
 - What is a composite key? a multi-column primary key (usually this would be a natural key)
 - What is a foreign key? - a column that references an indexed column of another table
 - what is an index? some small portion (1 column) of table data is used for rapid lookup on the real table, by allowing our queries to not have to check every row, to skip the unnecessary ones
 - What is the "clustered" index - in many implementations of SQL this is the actual natural ordering of rows in the table.
 - What is referential integrity? - A rule that ensures consistency where there is a foreign key reference
 - What are scalar funcitons? UCASE, LCASE, CONCAT - for every input there is an output
 - What are aggregate functions? COUNT, SUM, - There is exactly one value outpuuted regardless of how many inputs
 - What is a subquery? SELECT * FROM (SELECT * FROM TABLE) inside a single SQL statement, multiple nested queries where inner queries' result sets are used for the outer query
 - What is UNION? - Making multiple selects for multiple result sets, and merging these - Think of this one as "vertical"
   - What are the rules about unioning? must havge the same number of columns, and those columns must be compatible enough to coerce the data into a single data type
 - What is JOIN? - merging of two tables in order to create a merged result set - Think of this one as "horizontal"
 - What sorts of joins exist in SQL?
   - inner - where the data in both tables in the ON columns are present and matching 
   - outer - (FULL OUTER JOIN) all data from both tables, anywhere the data doesn't match we get null data
   - left - includes everything from the "left" table, and only matches from the "right"
   - right - includes everything from the "right" table, and only matches from the "left" where "left" refers to the tables already being selected (opr already joined previously) and "right" refers to the table currently being joined
   - cross - this produces a result set that is the "cartesian product" of both tables, you will get X*Y rows where X and Y are the nuymber of rows in either table - Kyle has no idea what the use case of this even is.
   - self - join a table with itself SELECT * FROM tableA A1 JOIN tableA A2 ON A1.key = A2.somethingelse
   - natural - join two tables ON columns where they share a name and data type
 - What is a transaction? - unit of work
 - ACID - Transaction Properties
   - Atomicity - how the transaction is committed - all of the "work" are done or none are, no in between
   - Consistency - the database should only ever go from consistent (valid) state to consistent state, no in between, there is no chance that during a transaction we commit an invalid state
   - Isolation - refers to transactions being done on the database state/data seperately so two transactions don't interfere with eachother
   - Durability - once something is committed that is permenant, there should be no disaster which could revert the database back to before the commit
 - What are the transaction isolation levels?
 From most isolated to least, where more isolated means more indemnified from read phenomena, but also more likely to cause latency or blocking
 Serializable
 Repeatable Read
 Read Committed
 Read uncommitted

 - What is a dirty-read? What isolation level(s) resolve this phenonmenon?
 - What is a phantom-read? What isolation level(s) resolve this phenonmenon?
 - What is a non-repeatable read? What isolation level(s) resolve this phenonmenon?
 - Is SQL considered a procedural, declarative, or functional language?
 today it is all 3, at first it was only functional until the "procedural language" standard was included, now it is all 3.
 - How can you select all of the entries in a table (ex: Users) including all columns? SELECT * FROM TABLE
 - What is a WHERE clause used for? Criteria for selecting some rows, defines which rows are included in the results
 - How can you sort the entries in your result set by a particular column? ORDER BY column, ORDER BY DESC to reverse the order
 - What is the purpose of the GROUP BY clause? - used with aggregate functions to group results based on aggregation
 
 Connection conn = DriverManager.getConnection("url", username, pass);
 String sql = "SELECT * FROM table WHERE id = ?";
 PreparedStatement pstmt = conn.prepareStatement(sql);
 pstmt.setInt(1, 5);
 ResultSet rs = pstmt.executeQuery();
 while(rs.next()) {
    //do something with each row
 }
 
 - What is JDBC? Java database Connectivity
 - Explain how you would connect your Java application to a database using JDBC.
 - What is the difference between a Statement and PreparedStatement?
 - Are DML statements in JDBC automatically committed? Is this a problem? autocommit mode
 - When would you use a CallableStatement?
 - What is SQL injection?
 - Why is it recommended to use a PreparedStatement over a Statement?
