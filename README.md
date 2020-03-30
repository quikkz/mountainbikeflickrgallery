# Flickr Mountainbike

This application is integrated with flickr using their Rest API. The application i quite simple as it calls only one method; flickr.groups.pools.getPhotos and specifically the group 'Mountainbiking' which lists random pictures that has something to do with mountainbikes. The call returns images from the group and they are listed on the startpage of the application using a recyclerview with a GridLayoutManager with 3 columns to make it look like a gallery.

## Installation
To fire up this application just clone this repository, install Android Studio and you will be good to go. Android studio will guide you through any Android SDKs / NDKs that you need to install.

## Home Assignment - Flickr Gallery
I have to start by saying that this was one of the funniest assignments ever taken! I am working 100% at the moment on other projects and im moving to a new apartment on wednesday so my time has been limited. I have spent about 3-4 hours on this assignment. The application is scaling the images according to the screen width in some manner so im hoping i got that right in some way! If I would have had more time I would make the API-implementation more generic as to handle the tokens etc. For now it´s using a token fetched from the api console and is static. (If the application wont work and it throws an error message its probobly because of this) I would also use fragments instead of just a activity as the solution is right now, but since the application only has one page i didnt focus on that.

In my solution i have choosen to list the images in a grid with 3 images on each row to make it look like a gallery app. For each image i am using scaleType = centerCrop which will automatically crop the image starting from the center.(This will maintain the images aspect ratio). I am also using layout_constraintDimensionRatio = 1:1. This means that the image will have the same height as width to make it look like a gallery image square.

Im sorry if i may have  misunderstood some of the requirements but I hope that you will see on the quality and structure of my code that I am a developer with a couple of years behind me :)
