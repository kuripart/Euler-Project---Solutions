#Problem 6 - Euler Project
import math
#import sys
#sys.path.append('/usr/local/lib/python3.6/site-packages')
import cv2
import numpy as num
input = 100
sum_n = (input*(input+1))/2 #formula
sum_n_sqr = ((input*(input+1)*((input*2)+1))/6) #formula
sqr_all_sum = math.pow(sum_n,2)
diff = sqr_all_sum - sum_n_sqr
print(diff)
