# Write a computer program capable of reducing the number of intensity levels in an image from 256 to 2,
# in integer powers of 2. # The desired number of intensity levels needs to be a variable input to your program.

#Author Victor Caldas


# Import the Python Image Library
from PIL import Image
import time

# Load original image and map pixels
im = Image.open("image.tif")
pixels = im.load();

# ----- Start code using PIL -----
start_time = time.time()
width, height = im.size

print(im.size)

#Create a new image
img = Image.new(im.mode, im.size)
pixelMap = img.load()

# Change this value to determine binary images
threshold = 125


# This loops checks one image but add the values to another.
for i in range(width):
    for j in range(height):
        if(pixels[i,j] > threshold):
            pixelMap[i, j] = 256;
        else:
            pixelMap[i,j] = 0;
img.show()

print("-Using PIL -- %s seconds ---" % (time.time() - start_time))


# ----  End code using PIL -----


### Using Scikit-image



