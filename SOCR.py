from PIL import Image

import numpy as np
import pytesseract
import pyscreenshot as ImageGrab
sudoku = [
        [0,0,0, 0,0,0, 0,0,0],
        [0,0,0, 0,0,0, 0,0,0],
        [0,0,0, 0,0,0, 0,0,0],

        [0,0,0, 0,0,0, 0,0,0],
        [0,0,0, 0,0,0, 0,0,0],
        [0,0,0, 0,0,0, 0,0,0],

        [0,0,0, 0,0,0, 0,0,0],
        [0,0,0, 0,0,0, 0,0,0],
        [0,0,0, 0,0,0, 0,0,0]
]
boxSize = 50
boxcounty = 0
boxcountx = 0
x1 = 1198
y = 480
for boxcounty in range(9):
    for boxcountx in range(9):
        im = ImageGrab.grab(bbox=(x1+boxSize*boxcountx, y+boxSize*boxcounty, x1+boxSize*(boxcountx+1), y+boxSize*(boxcounty+1)))
        imgString = r"C:\\Users\\AlbertinGa\\Documents\\GitHub\\sudoku-solver\\img\\image.png"
        im.save(imgString)
        number = pytesseract.image_to_string(Image.open(imgString), lang='eng', config='--psm 10 --oem 3 -c tessedit_char_whitelist=0123456789')
        if number == "":
            sudoku[boxcountx][boxcounty] = 0
        elif 1 or 2 or 3 or 4 or 5 or 6 or 7 or 8 or 9:
            sudoku[boxcounty][boxcountx] = number
    print(sudoku[boxcounty][boxcountx])
print(np.matrix(sudoku))
