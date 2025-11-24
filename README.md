# BookApp - Android Multi-Activity Application

## Project Overview
A comprehensive Android application demonstrating multi-activity navigation, implicit intents, object passing, and alternative resources including language-specific colors.

## Features Implemented 

### 1. **Three Activity Structure**
- **MainActivity**: Collects book information (title, author, year)
- **BookDetailsActivity**: Displays book details and captures book photo
- **IntentsActivity**: Demonstrates two common implicit intents

### 2. **Object Passing Between Activities**
- Created `Book` class implementing `Parcelable` interface
- Book object is created in MainActivity and passed to BookDetailsActivity
- Data persists through configuration changes

### 3. **Common Implicit Intents**
- **Camera Intent** (Activity 2): Take a photo of the book using MediaStore.ACTION_IMAGE_CAPTURE
- **Web Browser Intent** (Activity 3): Open URLs using Intent.ACTION_VIEW
- **Email Intent** (Activity 3): Send emails using Intent.ACTION_SENDTO

### 4. **Alternative Resources**

#### Resource Type 1: **Strings** (strings.xml)
- Default (English) strings in `values/strings.xml`
- Arabic translations in `values-ar/strings.xml`
- Demonstrates localization support

#### Resource Type 2: **Colors** (colors.xml)
- Default color scheme in `values/colors.xml` (Blue/Orange theme)
- Arabic-specific colors in `values-ar/colors.xml` (Green/Pink theme)
- Shows language-specific UI customization

#### Resource Type 3: **Dimensions** (dimens.xml)
- Standard padding and text size values
- Maintains consistent spacing throughout the app

#### Additional: **Drawable** (ic_book.xml)
- Vector drawable for book icon
- Used in the main activity

### 5. **State Preservation**
All activities implement `onSaveInstanceState()` and restore state in `onCreate()`:
- MainActivity: Saves entered book data
- BookDetailsActivity: Saves captured photo
- IntentsActivity: Saves URL and email form data

### 6. **No Persistent Storage**
- App uses only in-memory storage
- Data is passed between activities using Intents
- State is maintained during configuration changes

## Project Structure
```
BookApp/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/com/example/bookapp/
│   │       │   ├── Book.java
│   │       │   ├── MainActivity.java
│   │       │   ├── BookDetailsActivity.java
│   │       │   └── IntentsActivity.java
│   │       ├── res/
│   │       │   ├── drawable/
│   │       │   │   └── ic_book.xml
│   │       │   ├── layout/
│   │       │   │   ├── activity_main.xml
│   │       │   │   ├── activity_book_details.xml
│   │       │   │   └── activity_intents.xml
│   │       │   ├── values/
│   │       │   │   ├── strings.xml
│   │       │   │   ├── colors.xml
│   │       │   │   ├── dimens.xml
│   │       │   │   └── themes.xml
│   │       │   └── values-ar/
│   │       │       ├── strings.xml
│   │       │       └── colors.xml
│   │       └── AndroidManifest.xml
│   └── build.gradle
├── build.gradle
├── settings.gradle
└── gradle.properties
```

## How to Run

### Prerequisites
- Android Studio Arctic Fox or later
- Android SDK API Level 24 or higher
- Java 8 or higher

### Steps
1. Clone the repository or download the project
2. Open Android Studio
3. Select "Open an Existing Project"
4. Navigate to the BookApp folder and click OK
5. Wait for Gradle sync to complete
6. Click Run (green play button) or press Shift + F10
7. Select an emulator or connected device

## Testing the Features

### Test 1: Object Passing
1. Launch the app
2. Enter book title, author, and year
3. Click "Add Book"
4. Verify book details are displayed in Activity 2

### Test 2: Camera Intent
1. In Activity 2, click "Take Book Photo"
2. Camera app opens
3. Take a photo
4. Photo displays in the ImageView

### Test 3: State Preservation
1. Enter data in any activity
2. Rotate the device
3. Verify data is preserved

### Test 4: Web Browser Intent
1. Navigate to Activity 3
2. Enter a URL (e.g., "google.com")
3. Click "Open in Browser"
4. Browser opens with the URL

### Test 5: Email Intent
1. In Activity 3, enter email details
2. Click "Send Email"
3. Email app opens with pre-filled data

### Test 6: Alternative Resources
1. Change device language to Arabic (Settings → System → Languages)
2. Reopen the app
3. Observe different strings and colors

## Key Technical Implementations

### Parcelable Implementation
```java
public class Book implements Parcelable {
    // Efficient object serialization for Intent passing
}
```

### State Saving
```java
@Override
protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putString(STATE_KEY, value);
}
```

### Implicit Intents
```java
// Camera Intent
Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
startActivityForResult(takePictureIntent, REQUEST_CODE);

// Browser Intent
Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
startActivity(browserIntent);

// Email Intent
Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
emailIntent.setData(Uri.parse("mailto:" + email));
startActivity(Intent.createChooser(emailIntent, "Send email"));
```

## Assignment Requirements Checklist

- ✅ First activity collects book data (title, author, year)
- ✅ Book object passed via Intent to second activity
- ✅ Second activity displays book details
- ✅ Photo capture using common intent (camera)
- ✅ Next button to navigate to third activity
- ✅ Two additional common intents implemented (web browser, email)
- ✅ Three types of Android resources (strings, colors, dimensions + drawable)
- ✅ App saves activity state on device rotation
- ✅ No persistent storage used
- ✅ Clean, modern UI design

## Dependencies
```gradle
implementation 'androidx.appcompat:appcompat:1.6.1'
implementation 'com.google.android.material:material:1.11.0'
implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
implementation 'androidx.cardview:cardview:1.0.0'
```

## Minimum SDK Requirements
- **Minimum SDK**: API 24 (Android 7.0)
- **Target SDK**: API 34 (Android 14)

## Video Demonstration
Create a 30-60 second video showing:
1. Opening the app and entering book data
2. Viewing book details
3. Taking a photo with the camera
4. Opening a website in the browser
5. Composing an email
6. Rotating the device to show state preservation
7. (Optional) Changing language to show Arabic resources

## GitHub Repository
Upload your code to GitHub:
```bash
git init
git add .
git commit -m "Initial commit - BookApp Android Assignment"
git remote add origin <your-repo-url>
git push -u origin main
```

## License
This project is created for educational purposes as part of an Android development assignment.

## Author
[Sudha Chandran]
[Your Student ID]
[Date: November 2025]
