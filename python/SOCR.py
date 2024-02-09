from PIL import Image

import pytesseract
import pyscreenshot as ImageGrab
boxSize = 36
boxcounty = 0
boxcountx = 0
x1 = 1041
y = 202
for boxcountx in range(9):
    for boxcounty in range(9):
        im = ImageGrab.grab(bbox=(x1+boxSize*boxcountx, y+boxSize*boxcounty, x1+boxSize*(boxcountx+1), y+boxSize*(boxcounty+1)))
        imgString = r"img\im"+str(boxcountx)+str(boxcounty)+r".png"
        im.save(imgString)

print("Done")