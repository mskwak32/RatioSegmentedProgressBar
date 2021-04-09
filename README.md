Ratio segmented progressbar
===========================

<img src = "https://user-images.githubusercontent.com/39761087/114204284-fa173800-9993-11eb-9ee8-2ad15533f75c.PNG" />

```kotlin
class RatioSegmentedProgressBarDrawable(
        @ColorInt private val foregroundColor: Int,
        @ColorInt private val backgroundColor: Int,
        segmentValueList: List<Long>,
        private val gapWidth: Float
) : Drawable()
```
----------------------------------------------

-example
```kotlin
val valueList = listOf(10L,20L,50L,90L,30L)
progressBar.progressDrawable = RatioSegmentedProgressBarDrawable(Color.BLUE, Color.GRAY, valueList, 20f)
```