# Food and Fun!
Android application displaying various hand-picked attractions and restaurants in the local Chicago area, and separate application which sends broadcasts to launch on default the chosen category in the main application. Created using the Android flavor of Java. CS 478 Project 3, UIC Spring 2022.

## Table of contents
* [General Info](#general-info)
* [Getting Started](#getting-started)
* [Other Requirements](#other-requirements)
* [Technologies](#technologies)
* [Credits](#credits)
* [Visual Demonstration](#visual-demonstration)

## General info
This project is the third project for CS 478 (Software Development for Mobile Platforms) at the University of Illinois at Chicago, Spring 2022. Our task was to design and code two new Android apps meant to work together on an Android device running version Android 11 (API 30). The first app helps visitors in Chicago decide on points of interest in the city. The second app has specific information about the points of interest. 

**Application 1** was required to define an activity containing two read-only text views and two buttons. The buttons, when selected, will first show a short toast message, then broadcast two different implicity intents (e.g., attractions and restaurants) depending on the button pressed. The text views describe the meaning of the buttons to the device user. Application 2 was required to receive the intents. Depending on the kind of intent that was received, 

**Application 2** (Food and Fun!) was required to launch one of two activities: the first activity (attractions) displays information about 5 points of interest in the city of Chicago, Illinois; the second activity shows at least 5 restaurants located within Chicago’s city limits. Application 2 also maintains an options menu and an action bar. The action bar shows the name of the application and the overflow area. The options menu allows a device user to switch between the two categories. Each of the two activities in Application 2 contains two fragments. The first fragment displays a list (either the attractions or the restaurants, depending on the activity). The device user may select any item from either list; the currently selected item will stay highlighted until another item is selected. The second fragment shows the official web site of the highlighted item using a Webview.

## Getting Started
If you would like to download the app from the Google Play Store, click **here**. If you would like to browse through the source code in the environment it was created in, make sure you have **Android Studio 2021.1.1** installed.
* Windows: [download here](https://redirector.gvt1.com/edgedl/android/studio/install/2021.1.1.20/android-studio-2021.1.1.20-windows.exe)
* Mac (Intel): [download here](https://redirector.gvt1.com/edgedl/android/studio/install/2021.1.1.20/android-studio-2021.1.1.20-mac.dmg)
* Mac (ARM): [download here](https://redirector.gvt1.com/edgedl/android/studio/install/2021.1.1.20/android-studio-2021.1.1.20-mac_arm.dmg)
* Linux: [download here](https://redirector.gvt1.com/edgedl/android/studio/ide-zips/2021.1.1.20/android-studio-2021.1.1.20-linux.tar.gz)
* Chrome OS: [download here](https://redirector.gvt1.com/edgedl/android/studio/install/2021.1.1.20/android-studio-2021.1.1.20-cros.deb)

Once you are ready, open the project(s) in Android Studio. Ensure that the Run/Debug Configurations are set and set the device to a Pixel 3a XL using API 30. The application should load up and look something like this:

![App Start](images/app_start.png)


The first activity of the application shows animal thumbnails in just two columns on the screen as to provide a lush, viewable image, as well as the animal name beneath, created using a couple different XML layouts (a main GridView and definition for each item in the GridView) and a customized version of BaseAdapter for control handling. Scrolling is enabled by default as not all animals are immediately viewed on the screen. The app handles orientation changes flawlessly through seperate landscape layout files. 

Any single click on any item in the grid (i.e. any animal thumbnail) brings about the second activity, which is simply an enlarged version of the image. A click on this enlarged image will bring about the *third* activity, which displays interesting facts about that animal.  

A "long click" on any item in the grid (i.e. any animal thumbnail) within the first activity shows a context menu with three options: 
* **"View Image"** will launch the second activity, which simply displays an enlarged version of the animal image.
* **"Interesting Facts"** will launch the third activity, which displays interesting facts about that animal on the screen.
* **"See Wikipedia Page"** starts an activity with an *ACTION_VIEW* intent, which should launch the device's default browser and open up that animal's Wikipedia page using a linked Uri. 

## Other Requirements
* Both applications were required display optimally in landscape mode. 
* The activities in Application 2 initially show only the first fragment across the entire width of the screen. 
    * As soon as a user selects an item, the first fragment is “shrunk” to about 1/3 of the screen’s width. This fragment will appear in the left-hand side of the screen, with the second fragment taking up the remaining 2/3 of the display on the right. 
    * Pressing the “back” button will return the activity to its initial configuration. 
* The action bar in Application 2 should be displayed at all times regardless of whether the device is in portrait or landscape mode.
* The state of Applicaation 2 should be retained across device reconfigurations, e.g., when the device is switched from landscape to portrait mode and vice versa. 
    * This means that the selected list item (in the first fragment) and the page displayed in the second fragment will be kept during configuration changes.
* Using a ViewModel with LiveData for communication between fragments is required.
    
## Technologies
Project is created with:
* Android Studio Bumblebee 2021.1.1
* Java SE Development Kit (JDK) 11.0.11

## Credits
All credits for the project idea go to Professor Ugo Buy. Credits to much of the [GridLayoutActivity.java](app/src/main/java/com/example/project2/GridLayoutActivity.java) and [ImageAdapter.java](app/src/main/java/com/example/project2/ImageAdapter.java) codebase also go to Professor Ugo Buy as the beginning template for our project. Credits to [Pexels.com](https://www.pexels.com/) and the following contributors listed below for the images used throughout this project:
* [Flickr](https://www.pexels.com/photo/tiger-beside-tree-145971/)
* [Husain Chauhan](https://www.pexels.com/photo/silhouettes-of-unrecognizable-arabic-man-with-camel-at-sunset-4456133/) 
* [Pixabay](https://www.pexels.com/photo/chimpanzee-sitting-on-gray-stone-in-closeup-photography-during-daytime-33787/)
* [Pixabay](https://www.pexels.com/photo/brown-white-and-black-eagle-flying-nearby-pink-flower-field-158330/)
* [antonytrivet](https://pixabay.com/images/id-5799523/)
* [Valdemaras D.](https://www.pexels.com/photo/group-of-people-taking-picture-of-shark-1700656/)
* [Sameera Madusanka](https://www.pexels.com/photo/macro-photography-of-green-crested-lizard-735174/)

All credits to technologies used are given to their owners and all items specified in their respective licenses are adhered to throughout this project.  

## Visual Demonstration
The following link leads to a visual demonstration of the project.
* https://youtu.be/iwDWsdAIJsk
