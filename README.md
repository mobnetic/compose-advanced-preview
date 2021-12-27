# AdvancedPreview
[![Release](https://jitpack.io/v/com.mobnetic/compose-advanced-preview.svg)](https://jitpack.io/#com.mobnetic/compose-advanced-preview)

Customisable Preview of system UI decoration for Jetpack Compose.  

### Use cases
- Want the Preview in Android Studio to look more like in real app on device.
- Save preview output for marketing or documentation purposes.
- You have automated capturing of Composables in code and would like them to be decorated with system UI.

## Documentation

```kotlin
@Composable
fun AdvancedPreview(
    device: Device,
    settings: Settings,
    statusBar: StatusBar,
    navigationBar: NavigationBar,
    backgroundColor: Color,
    content: @Composable () -> Unit
)
```

#### Device
| Property | Description |
|---|---|
| `screenWidth`<br/>`screenHeight` | Configure specific screen size.<br/>Default size is the same as `@Preview(showSystemUi = true)` |
| `statusBarSize` | Specify custom StatusBar size. Default value is `24.dp` |
| `statusBarContentPadding` | Specify custom StatusBar inner padding. Default value is `PaddingValues(start = 8.dp, end = 4.dp)` |
| `displayCutout` | Currently only "O-shaped" cutout is supported. You can customize size, margins and position |

#### Settings
| Property | Description |
|---|---|
| `time` | Customize time displayed on StatusBar by providing `hours` and `minutes`. Default value is `StatusBarTime(hours = 12, minutes = 0)` |
| `showDisplayCutoutDecoration` | Specify whether to draw the black mask as display cutout decoration |
| `navigationType` | Choose between navigation types: `NavigationType.ThreeButtons` or `NavigationType.Gesture` |

#### StatusBar / NavigationBar
| Property | Description |
|---|---|
| `color` | Control the background color |
| `darkIcons` | Control whether icons are light of dark |
| `overlaysContent` |  Draw content behind the bar, allowing for edge-to-edge content.<br/>There's a build-in support for [Accompanist-inset](https://google.github.io/accompanist/insets/). |

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

## Download
```
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation "com.mobnetic:compose-advanced-preview:<version>"
}
```
