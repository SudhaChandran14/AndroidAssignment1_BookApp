# BookApp - Quick Reference Card

## Assignment Requirements vs Implementation

| Requirement | Implementation | File Location |
|------------|----------------|---------------|
| First activity collects book data | MainActivity with 3 EditText fields | MainActivity.java |
| Pass book object to second activity | Book class implements Parcelable | Book.java |
| Display book details | TextView shows all book info | BookDetailsActivity.java |
| Take photo (common intent) | MediaStore.ACTION_IMAGE_CAPTURE | BookDetailsActivity.java |
| Next button to third activity | Navigate to IntentsActivity | BookDetailsActivity.java |
| Two more common intents | Web Browser + Email | IntentsActivity.java |
| Three Android resources | Strings, Colors, Dimensions | values/ folder |
| Language-specific resources | Arabic strings & colors | values-ar/ folder |
| Save state on rotation | onSaveInstanceState() in all | All activities |
| No persistent storage | Only in-memory & intent data | N/A |

## Key Code Snippets

### 1. Making Book Parcelable
```java
public class Book implements Parcelable {
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(author);
        dest.writeString(year);
    }
}
```

### 2. Passing Object Between Activities
```java
// Sending
Book book = new Book(title, author, year);
Intent intent = new Intent(this, BookDetailsActivity.class);
intent.putExtra("book", book);
startActivity(intent);

// Receiving
Book book = getIntent().getParcelableExtra("book");
```

### 3. Camera Intent
```java
Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
```

### 4. Web Browser Intent
```java
Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
startActivity(browserIntent);
```

### 5. Email Intent
```java
Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
emailIntent.setData(Uri.parse("mailto:" + email));
emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
startActivity(Intent.createChooser(emailIntent, "Send email"));
```

### 6. Save State
```java
@Override
protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putString(STATE_KEY, value);
}

// Restore in onCreate
if (savedInstanceState != null) {
    String value = savedInstanceState.getString(STATE_KEY);
}
```

## Resource Types Explained

### 1. Strings (strings.xml)
- **Default**: values/strings.xml (English)
- **Arabic**: values-ar/strings.xml
- **Usage**: `getString(R.string.app_name)`
- **XML**: `android:text="@string/app_name"`

### 2. Colors (colors.xml)
- **Default**: Blue/Orange theme
- **Arabic**: Green/Pink theme
- **Usage**: Shows language-specific UI
- **XML**: `android:backgroundTint="@color/primary_color"`

### 3. Dimensions (dimens.xml)
- Padding values: small, medium, large
- Text sizes: small, medium, large, title
- **Usage**: Consistent spacing
- **XML**: `android:padding="@dimen/padding_large"`

### 4. Drawable (ic_book.xml)
- Vector drawable
- Book icon on main screen
- **Usage**: `android:src="@drawable/ic_book"`

## Project File Structure
```
BookApp/
├── app/
│   ├── src/main/
│   │   ├── java/com/example/bookapp/
│   │   │   ├── Book.java                    [Parcelable model]
│   │   │   ├── MainActivity.java            [Activity 1]
│   │   │   ├── BookDetailsActivity.java     [Activity 2]
│   │   │   └── IntentsActivity.java         [Activity 3]
│   │   ├── res/
│   │   │   ├── drawable/ic_book.xml         [Icon resource]
│   │   │   ├── layout/
│   │   │   │   ├── activity_main.xml
│   │   │   │   ├── activity_book_details.xml
│   │   │   │   └── activity_intents.xml
│   │   │   ├── values/                      [Default resources]
│   │   │   │   ├── strings.xml
│   │   │   │   ├── colors.xml
│   │   │   │   └── dimens.xml
│   │   │   └── values-ar/                   [Arabic resources]
│   │   │       ├── strings.xml
│   │   │       └── colors.xml
│   │   └── AndroidManifest.xml
│   └── build.gradle
├── build.gradle
├── settings.gradle
└── README.md
```

## Testing Commands

### Run on Emulator
```
./gradlew installDebug
```

### Rotate Emulator
- **Windows/Linux**: Ctrl + F11 / Ctrl + F12
- **Mac**: Cmd + Left / Cmd + Right

### Change Language
Settings → System → Languages → Add Arabic → Move to top

## Common Intent Actions Reference

| Intent Action | Purpose | Used In |
|---------------|---------|---------|
| MediaStore.ACTION_IMAGE_CAPTURE | Take photo | Activity 2 |
| Intent.ACTION_VIEW | Open URL in browser | Activity 3 |
| Intent.ACTION_SENDTO | Send email | Activity 3 |
| Intent.ACTION_DIAL | Make phone call | (alternative) |
| Intent.ACTION_SEND | Share content | (alternative) |

## Video Recording Checklist

Your 30-60 second video should show:
- ✅ App launch and data entry
- ✅ Navigation between activities
- ✅ Camera intent working
- ✅ Photo displayed
- ✅ Web browser intent
- ✅ Email intent
- ✅ Device rotation (state saved)
- ✅ (Bonus) Arabic language switch

## GitHub Submission

```bash
# Initialize
git init
git add .
git commit -m "BookApp - Android Assignment"

# Create repo on GitHub, then:
git remote add origin YOUR_REPO_URL
git push -u origin main
```

**Repository URL Format:**
`https://github.com/USERNAME/BookApp-Android-Assignment`

## Last-Minute Checklist

Before submission:
- [ ] All three activities work
- [ ] Camera takes and displays photo
- [ ] Web browser opens URLs
- [ ] Email client opens
- [ ] State preserved on rotation
- [ ] Arabic resources show different colors
- [ ] Video recorded and uploaded
- [ ] Code pushed to GitHub
- [ ] README included
- [ ] .gitignore added

## Key Points to Mention in Video

1. "This is Activity 1 where I collect book data"
2. "The Book object is passed using Parcelable"
3. "Activity 2 displays the book and uses camera intent"
4. "Activity 3 demonstrates browser and email intents"
5. "Watch how state is preserved when I rotate"
6. "The app supports Arabic with different colors"

## If Something Doesn't Work

1. **Camera**: Use physical device, not emulator
2. **Rotation**: Check configChanges in AndroidManifest
3. **Intents**: Test with different apps installed
4. **Colors**: Clean and rebuild project
5. **Gradle**: File → Invalidate Caches → Restart

---

**Remember:** This is a complete, working Android application that meets all assignment requirements! 🎉
