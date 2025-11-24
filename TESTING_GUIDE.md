# BookApp Setup and Testing Guide

## Quick Start Guide

### Step 1: Import Project to Android Studio
1. Open Android Studio
2. Click "Open" or "Open an Existing Project"
3. Navigate to the `BookApp` folder
4. Click "OK"
5. Wait for Gradle to sync (this may take a few minutes)

### Step 2: Configure Emulator (if needed)
1. Click on AVD Manager (phone icon in toolbar)
2. Click "Create Virtual Device"
3. Select a device (e.g., Pixel 5)
4. Choose a system image (API 24 or higher)
5. Click "Finish"

### Step 3: Run the Application
1. Select your emulator or connected device from the dropdown
2. Click the green "Run" button (or press Shift + F10)
3. Wait for the app to build and install

## Testing Checklist

### ✅ Test 1: Book Data Entry and Object Passing
**Steps:**
1. Launch the app
2. Enter "The Great Gatsby" as title
3. Enter "F. Scott Fitzgerald" as author
4. Enter "1925" as year
5. Click "Add Book" button

**Expected Result:**
- App navigates to Book Details screen
- All three fields are displayed correctly
- Data matches what you entered

---

### ✅ Test 2: Camera Intent
**Steps:**
1. From Book Details screen, click "Take Book Photo"
2. Camera app opens
3. Take a photo (or use existing image in emulator)
4. Confirm/Accept the photo

**Expected Result:**
- Photo appears in the ImageView below the button
- Image displays correctly

---

### ✅ Test 3: State Preservation on Rotation
**Steps:**
1. On the main screen, enter some book data (don't submit)
2. Rotate the device/emulator (Ctrl + F11 or Ctrl + F12)
3. Check if the entered data is still there

**Expected Result:**
- All entered text remains in the fields
- No data loss

**Repeat for other activities:**
- In Book Details: Take a photo, then rotate
- In Intents Activity: Enter URL/email data, then rotate

---

### ✅ Test 4: Web Browser Intent
**Steps:**
1. Navigate to the third activity (click Next from Book Details)
2. In the "Open Web Browser" section, enter "google.com"
3. Click "Open in Browser"

**Expected Result:**
- Browser app opens
- Website loads successfully

---

### ✅ Test 5: Email Intent
**Steps:**
1. In the "Send Email" section, enter:
   - Email: "test@example.com"
   - Subject: "Test Email"
   - Message: "This is a test message"
2. Click "Send Email"

**Expected Result:**
- Email client chooser appears (Gmail, Outlook, etc.)
- Email fields are pre-filled with your data

---

### ✅ Test 6: Alternative Resources (Language)
**Steps:**
1. Go to device Settings → System → Languages & input → Languages
2. Add Arabic (العربية) and move it to the top
3. Return to the app (or relaunch it)

**Expected Result:**
- All text appears in Arabic
- Button colors change (Green/Pink theme instead of Blue/Orange)
- Layout adjusts for RTL (Right-to-Left)

**To switch back:**
- Go to Settings and move English to the top

---

## Common Issues and Solutions

### Issue 1: Gradle Sync Failed
**Solution:**
- Check internet connection
- In Android Studio: File → Invalidate Caches → Invalidate and Restart

### Issue 2: Camera Not Working in Emulator
**Solution:**
- In AVD Manager, edit your emulator
- Go to Advanced Settings
- Set both cameras to "Emulated" or "Webcam"

### Issue 3: App Crashes on Photo Capture
**Solution:**
- Make sure camera permissions are granted
- Try using a physical device instead of emulator

### Issue 4: Colors Not Changing with Language
**Solution:**
- Make sure you've created both:
  - values/colors.xml
  - values-ar/colors.xml
- Clean and rebuild: Build → Clean Project → Rebuild Project

## Recording Your Demonstration Video

### What to Show (30-60 seconds):
1. **[0-10s]** Show the main screen, enter book data
2. **[10-15s]** Show book details screen
3. **[15-25s]** Take a photo with camera
4. **[25-30s]** Show third activity with web browser intent
5. **[30-35s]** Show email intent
6. **[35-40s]** Rotate device to show state preservation
7. **[40-45s]** (Optional) Show Arabic language version

### Recording Tips:
- Use Android Studio's built-in screen recorder: Run → Record Emulator
- Or use your phone's screen recorder
- Speak while demonstrating to explain what you're doing
- Keep it concise and focused

## Uploading to GitHub

### First Time Setup:
```bash
cd BookApp
git init
git add .
git commit -m "Initial commit - Android BookApp assignment"
```

### Create GitHub Repository:
1. Go to github.com
2. Click "New Repository"
3. Name it "BookApp-Android-Assignment"
4. Don't initialize with README (we already have one)
5. Copy the repository URL

### Push to GitHub:
```bash
git remote add origin https://github.com/YOUR_USERNAME/BookApp-Android-Assignment.git
git branch -M main
git push -u origin main
```

### Your GitHub link will be:
`https://github.com/YOUR_USERNAME/BookApp-Android-Assignment`

## Submission Checklist

Before submitting, verify:
- ✅ All activities work correctly
- ✅ Camera intent captures and displays photo
- ✅ Web browser and email intents work
- ✅ State is preserved on rotation
- ✅ Arabic resources show different colors
- ✅ Code is uploaded to GitHub
- ✅ Video is recorded (30-60 seconds)
- ✅ Video shows all features
- ✅ Video is uploaded to team channel

## What to Submit

1. **GitHub Repository Link**
   - Example: https://github.com/yourusername/BookApp-Android-Assignment

2. **Video Link**
   - Upload to Google Drive, YouTube (unlisted), or team channel
   - Make sure video is accessible

3. **Brief Description** (if required)
   - "Android multi-activity app demonstrating intents, object passing, and alternative resources"

## Grading Criteria Reference

Your app should demonstrate:
1. ✅ Three activities with proper navigation
2. ✅ Book object creation and passing
3. ✅ Camera intent implementation
4. ✅ Two additional common intents (web, email)
5. ✅ Three resource types (strings, colors, dimensions)
6. ✅ State preservation on rotation
7. ✅ No persistent storage
8. ✅ Clean UI design
9. ✅ Working video demonstration
10. ✅ GitHub repository with complete code

Good luck with your assignment! 🚀
