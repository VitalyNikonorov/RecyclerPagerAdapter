# RecyclerPagerAdapter
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[ ![Download](https://api.bintray.com/packages/vitalynikonorov/maven/recycler-pager-adapter/images/download.svg) ](https://bintray.com/vitalynikonorov/maven/recycler-pager-adapter/_latestVersion)

RecyclerPagerAdapter is a lightweight library that provide an ability for using `PagerAdapter` with `RecyclerView` like API. 
It also makes it possible to make an infinitely scrolling list based on the `PagerAdapter`.

## Demo

<img src="https://github.com/VitalyNikonorov/RecyclerPagerAdapter/blob/master/static-files/endless.gif"/>

## Usage

```groovy
dependencies {
    implementation 'net.nikonorov:recycler-pager-adapter:0.5.1'
}
```

Add your own adapter class (e.g. `MyAdapter`) and extend library's `RecyclerPagerAdapter`

```java
class MyAdapter extends RecyclerPagerAdapter<MainPagerAdapter.ViewHolder> 
```

Override abstract methods like for `RecyclerView` and set it for your `ViewPager`

## License
```
MIT License

Copyright (c) 2017 Vitaly Nikonorov (@VitalyNikonorov)

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
