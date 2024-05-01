# Exercise 2 - Login
Create a new Project (xml) which will show the following Layout:

<img src="result.png" width="200">

To create a field in which text can be entered us an EditText:

<EditText
    android:layout_width="250dp"
    android:layout_height="wrap_content"
    android:layout_gravity="center"
    android:hint="@string/hint_username" />

To extract the entered text from it use:

editText.text.toString()

When either the username or password field is empty and login is clicked, display the following error below the Button:
"Field cannot be empty"

## Bonus
Depending on which field is empty either display "Username field cannot be empty" or "Password field cannot be empty"

<details>
  <summary>Hint 🤫</summary>
  A LinearLayout is needed here. You can also control whether or not a View is shown with its visibility property
</details>
