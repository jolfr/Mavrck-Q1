# Mavrck Coding Exercise

## *Prompt:* Write a project using Kotlin or Java that reads the file, and is able to perform a GroupBy on an arbitrary number of fields/columns that outputs the distinct rows and an extra column with the COUNT of records in that row.

## *Approach:*

The two components of this exercise, the file processor and the custom function are decoupled and declared in FileProcessor.kt and aggregations/GroupByCount.kt respectively. I approached it in this way to improve testability, and have completed very lightweight unit testing on each component.