# Parmesan-Android
Parmesan is a simple android application that displays a list of meals and their recipes. It displays the images of the meals as well as ingredients and it's quantities. The application shows a list of latest meals, meals according to categories, and a screen of random meals.

# ScreenShots
![Screenshot](Parmesan_Android/art/LatestMeals.jpg)
![Screenshot](Parmesan_Android/art/Meal Categories.jpg)
![Screenshot](Parmesan_Android/art/RandomMeal.jpg)
      

# Libraries
- Picasso
- ConstraintLayout
- Retrofit
- Gson
- Android Support Library

# API
The application reads recipe data from The MealDB. 
URL: https://www.themealdb.com/

- Latest Meals : https://www.themealdb.com/api/json/v1/1/latest.php
- Meal Categories: https://www.themealdb.com/api/json/v1/1/categories.php
- Random Meal: https://www.themealdb.com/api/json/v1/1/random.php


# Architecture
The architecture used for Parmesan is Model-View-ViewModel.
