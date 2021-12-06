# AdvancedPreview
Customisable Preview of system UI decoration for Jetpack Compose.  

### Use cases
- Have better control over the Preview in Android Studio to make it look like in the real app.
- Capture images of Composables in code but would like them to be decorated with system UI.

## Documentation

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
| Property | Description |
|---|---|
| `screenWidth`<br/>`screenHeight` | Configure specific screen size.<br/>Default size is the same as `@Preview(showSystemUi = true)` |
| `statusBarSize` | Specify custom StatusBar size. Default value is `24.dp` |
| `navigationType` | Choose between navigation types: `NavigationType.ThreeButtons` or `NavigationType.Gesture` |


#### StatusBar / NavigationBar
| Property | Description |
|---|---|
| `color` | Control the background color |
| `darkIcons` | Control whether icons are light of dark |
| `overlaysContent` |  Draw content behind the bar, allowing for edge-to-edge content.<br/>There's a build-in support for [Accompanist-inset](https://google.github.io/accompanist/insets/). |

#### Time
| Property | Description |
|---|---|
| `hours` and `minutes`  |  Customize time displayed on StatusBar |

#### ... other
| Property | Description |
|---|---|
| `backgroundColor` | Specify background color for entire Preview |

## Usage
Simply wrap your screen Composable with `AdvancedPreview`.  
Configuration should be done in `AdvancedPreview` instead of passing arguments to `@Preview` annotation.

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
- Screen uses [Accompanist-inset](https://google.github.io/accompanist/insets/) which works out-of-the-box with `AdvancedPreview`.

| AdvancedPreview | Standard `@Preview` |
|---|---|
| <img src="/docs/Sample2AdvancedPreview.png" width="260"> | <img src="/docs/Sample2StandardPreview.png" width="260"> |

#### [Sample3](/sample/src/main/java/com/mobnetic/compose/advancedpreview/sample/Sample3.kt) demonstrates:
- Light background with dark icons on StatusBar and NavigationBar.
- Tall StatusBar 
- Gesture Navigation.

| AdvancedPreview | Standard `@Preview` |
|---|---|
| <img src="/docs/Sample3AdvancedPreview.png" width="260"> | <img src="/docs/Sample3StandardPreview.png" width="260"> |
