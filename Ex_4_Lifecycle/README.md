# Exercise 4 - Lifecycle
Create a new Project (xml).
Then override all Lifecycle functions:

onCreate, onStart, onStop, onResume, onPause, onRestart, onDestroy

To each function add a debug log using Log.d which will appear in the LogCat.
Start the App, rotate it, put the App to Background / Foreground, kill it, etc.

Observe what Lifecycle methods get invoked. 

You can also display a Toast alongside the logging in the LogCat using:<br>
Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

**Note:** This Toasts will show up delayed, to get an accurate representation of when the Lifecycle<br>
fun's are called rely on the LogCat logs!

<img src="activity_lifecycle.png" width="300">
