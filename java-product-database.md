You've been tasked with loading our product catalog.

## Getting Started

```no-highlight
et get java-product-database
cd java-product-database
createdb products
idea .
```

- Hibernate has been included in your `pom.xml` for you.
- You have been provided with a `persistence.xml`

## Core User Stories

### Create your schema

- Look at the data in `src/main/resources/catalog.json` to determine what fields your database will need
- Create a `schema.sql` file in the `src/main/resources/db` folder
- Import your schema

### Create your entity

- Using the schema as a guide create a `Product` class. Remember this must be a `POJO` (also known as Plain Old Java Object or Bean).
- Use annotations to ensure the `Product` can be used in conjunction with the database
- Ensure you create an `id` for your products

### Make sure it works!

- Create a Main.java which runs and creates a record for each item in the `catalog.json` (for now you can hard code the values to seed the data).


## Non-Core User Stories

### Seed the Product Catalog

```no-highlight
As a catalog manager
I want to load products from JSON
So that the catalog is easier to maintain
```

Acceptance Criteria:

- Running the `Seeder` will insert the products listed in `catalog.json` into the database.

Implementation Details:

- Making use of the work you've done above update the `Seeder.java` file to load the data directly from the JSON into the database.
- Update your `Main` class so that it is now only responsible for running the `Seeder`
- You will need to use Jackson in order to get the catalog into a malleable data structure. The JAR has already been included in your `POM.xml`

## More Non-Core!

These stories will require you to read ahead

### Re-run the Seed Script

```no-highlight
As a catalog manager
I want to load products from JSON repeatedly
So that the catalog is easier to maintain
```

Acceptance Criteria:

- Running the script multiple times does not result in duplicate rows

Implementation Details:

- Use the name to query the database. If the product already exists, do not insert it.

### Category Normalization

```no-highlight
As a catalog manager
I want to manage a list of categories
So that the products are easier to find
```

Acceptance Criteria:

- Create a `categories` table and populate it on the basis of what is in `catalog.json` as part of your `Seeder` routine.
- Load `categories` as you load your products into the database. Use a similar technique to what you implemented above so that duplicate category names are not inserted.
- Your products should reference this table in some way.
