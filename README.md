### Hexlet tests and linter status:
[![Actions Status](https://github.com/ddm14159/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/ddm14159/java-project-78/actions)
<a href="https://codeclimate.com/github/ddm14159/java-project-78/maintainability"><img src="https://api.codeclimate.com/v1/badges/38b76e833cb3122a9eb8/maintainability" /></a>
<a href="https://codeclimate.com/github/ddm14159/java-project-78/test_coverage"><img src="https://api.codeclimate.com/v1/badges/38b76e833cb3122a9eb8/test_coverage" /></a>

# Data Validator Library

## Introduction

The Data Validator is a flexible and powerful Java library designed to validate data structures with ease. This library allows you to define validation schemas for various data types, including strings, numbers, and complex objects (maps), ensuring that your data adheres to the specified rules and constraints.

Inspired by the popular `yup` library, the Data Validator provides a fluent API for defining and chaining validation rules, making it simple to create robust and maintainable validation logic in your applications.

## Features

- **Fluent Interface**: Easily chain validation methods to create readable and maintainable validation logic.
- **String Validation**: Check if strings are non-empty, match a pattern, meet a minimum length, and more.
- **Number Validation**: Validate numerical values to ensure they are positive, within a range, required, etc.
- **Object Validation**: Define and validate complex objects, ensuring the structure and data types are correct.

## Usage
Below are examples of how to use the Data Validator library to validate different types of data.

### String Validation
```
import hexlet.code.Validator;
import hexlet.code.schemas.StringSchema;

Validator v = new Validator();

StringSchema schema = v.string().required();

boolean result1 = schema.isValid("what does the fox say"); // true
boolean result2 = schema.isValid(""); // false
```
### Number Validation
```
import hexlet.code.Validator;
import hexlet.code.schemas.NumberSchema;

Validator v = new Validator();

NumberSchema schema = v.number().required().positive();

boolean result1 = schema.isValid(-10); // false
boolean result2 = schema.isValid(10); // true
```
### Object (Map) Validation
```
import hexlet.code.Validator;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.BaseSchema;

import java.util.HashMap;
import java.util.Map;

Validator v = new Validator();

Map<String, BaseSchema<String>> schemas = new HashMap<>();
schemas.put("firstName", v.string().required());
schemas.put("lastName", v.string().required().minLength(2));

MapSchema schema = v.map().sizeof(2).shape(schemas);

Map<String, Object> human1 = new HashMap<>();
human1.put("firstName", "John");
human1.put("lastName", "Smith");
boolean result1 = schema.isValid(human1); // true

Map<String, Object> human2 = new HashMap<>();
human2.put("firstName", "Anna");
human2.put("lastName", "B");
boolean result2 = schema.isValid(human2); // false
```
