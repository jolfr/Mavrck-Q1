# Mavrck Coding Exercise

## *Prompt:* Write a project using Kotlin or Java that reads the file, and is able to perform a GroupBy on an arbitrary number of fields/columns that outputs the distinct rows and an extra column with the COUNT of records in that row.

## *Approach:*

The two components of this exercise, the file processor and the custom function are decoupled and declared in FileProcessor.kt and aggregations/GroupByCount.kt respectively. I approached it in this way to improve testability, and have completed very lightweight unit testing on each component.

### Deployment

Ran the project locally and tested with Postman. Have yet to containerize it; approach would be to use multi-stage build that copies over the JRE. Single stage builds leave behind the build artifacts and run using the JDK instead of the JRE. As far as documentation is concerned, I've already generated the OpenApiV3 json for the one endpoint, but stumbled on setting up Swagger for a nice UI. Generating spec docs directly from the code saves time. I've also filled out docstrings for some internal functions, but have yet to fully cover the codebase.
