# AdvancedPreview
Customisable Preview of system UI decoration for Jetpack Compose.  

### Use cases
- Have better control over the Preview in Android Studio to make it look like in the real app.
- Capture images of Composables in code but would like them to be decorated with system UI.

## Features

```kotlin
@Composable
fun AdvancedPreview(
    device: Device,
    statusBar: StatusBar,
    navigationBar: NavigationBar,
    backgroundColor: Color,
    time: StatusBarTime,
    content: @Composable () -> Unit
)
```

#### Device
- Configire screen size using `screenWidth: Dp` and `screenHeight: Dp`.
- Choosing between navigation types using `navigationType` (`ThreeButtons` or `Gesture`).

#### StatusBar / NavigationBar
- Control background and icons color using `color: Color` and `darkIcons: Boolean`.
- Draw content behind - allow it to be "edge-to-edge" using `overlaysContent: Boolean`.

#### Time
- Customize time displayed on StatusBar (`hours: Int` and `minutes: Int`).

## Usage
Simply wrap your screen Composable with `AdvancedPreview`.  
Any configuration should be done in `AdvancedPreview` instead of passing arguments to `@Preview` annotation.

```kotlin
@Preview
@Composable
private fun SampleScreenPreview() {
    YourAppTheme {
        AdvancedPreview {
            SampleScreen()
        }
    }
}
```

## Samples

#### [Sample1](/sample/src/main/java/com/mobnetic/compose/advancedpreview/sample/Sample1.kt) demonstrates: 
- How to setup default `AdvancedPreview` and how it looks against standard `@Preview`

| AdvancedPreview | Standard `@Preview` |
|---|---|
| <img src="/docs/Sample1AdvancedPreview.png" width="260"> | <img src="/docs/Sample1StandardPreview.png" width="260"> |


#### [Sample2](/sample/src/main/java/com/mobnetic/compose/advancedpreview/sample/Sample2.kt) demonstrates:
- Translucent StatusBar and NavigationBar that overlay the screen's content.  
- Screen content uses [accompanist-inset](https://google.github.io/accompanist/insets/) which works out of the box with `AdvancedPreview`.

| AdvancedPreview | Standard `@Preview` |
|---|---|
| <img src="/docs/Sample2AdvancedPreview.png" width="260"> | <img src="/docs/Sample2StandardPreview.png" width="260"> |

#### [Sample3](/sample/src/main/java/com/mobnetic/compose/advancedpreview/sample/Sample3.kt) demonstrates:
- Light backround with dark icons on StatusBar and NavigationBar.
- Gesture Navigation.

| AdvancedPreview | Standard `@Preview` |
|---|---|
| <img src="/docs/Sample3AdvancedPreview.png" width="260"> | <img src="/docs/Sample3StandardPreview.png" width="260"> |
