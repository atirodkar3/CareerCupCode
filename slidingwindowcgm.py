import csv
#import scipy.stats.pearsonr
import numpy as np
import datetime as DT
import matplotlib.pyplot as plt
from pylab import *
from scipy.stats import *

def make_date(datestr):
		return DT.datetime.strptime(datestr, '%Y-%m-%d %H:%M:%S')

class cgmslidingcorr(object):
	
	def reader(self,file):		
		arr = np.genfromtxt(file, delimiter=',',
						converters={'Date': make_date}, names =  ('Date', '2TAPeaks', '3FAPeaks', '4LAPeaks', '5FAPoint', '6TAPoint', '7LAPoint', '8SkinTempAve', '9TAAve', '10LAAve', '11NBTempAve', 
		'12TAMAD', '13LAMAD', '14StepC', '15FAAve', '16FAMAD', '17GSRAve', '18LyingD', '19Sleep', '20PhysAc', '21EnExp', '22Sedent', '23Moderate', '24Vigorous', '25VVig', '26METs','27HRMValue','28SensorValue','29SensorDate','30HRMDate','31Extra'),
						dtype = None)
						
		index={1:'Date', 2:'2TAPeaks', 3:'3FAPeaks', 4:'4LAPeaks', 5:'5FAPoint', 6:'6TAPoint', 7:'7LAPoint', 8:'8SkinTempAve', 9:'9TAAve', 10:'10LAAve', 11:'11NBTempAve', 
		12:'12TAMAD', 13:'13LAMAD', 14:'14StepC', 15:'15FAAve', 16:'16FAMAD', 17:'17GSRAve', 18:'18LyingD', 19:'19Sleep', 20:'20PhysAc', 21:'21EnExp', 22:'22Sedent', 23:'23Moderate', 24:'24Vigorous', 25:'25VVig', 26:'26METs', 27:'27HRMValue', 28:'28SensorValue', 29:'29SensorDate', 30:'30HRMDate'}
		return arr,index
			
	def topten(self,farr,sarr,corr,xarr,yarr):
		corrmap={}
		for i in range(0,len(corr)):
			corrmap[corr[i]]=i
		corrtemp=sorted(corr,reverse=True)
		temp=[]
		if(len(corr)>9):
			
			for i in range(0,11):
				pos=corrmap[corrtemp[i]]
				temp.append([farr[pos],sarr[pos],corr[pos],xarr[pos],yarr[pos]])
		else:
			for i in range(0,len(corr)):
				pos=corrmap[corr[i]]
				temp.append([farr[pos],sarr[pos],corr[pos],xarr[pos],yarr[pos]])
		return temp
	
	def slider(self,size,shift,attribute,arr,index,outtemp):
		
		#col="CGMSlidingCorrelation"+index[attribute]+".csv"
		#crf= csv.writer(open(col, "wb"))
		farr=[]
		sarr=[]
		corr=[]
		xarr=[]
		yarr=[]
		
		print index[attribute]
		i=336
		j=1
		for i in range(336,len(arr)-size,shift):	
			for j in range(1,len(arr)-size,shift):
				#print abs(pearsonr( arr['28SensorValue'][i:i+size],arr[index[27]][j:j+size])[0])
				m=abs(pearsonr( arr['28SensorValue'][i:i+size],arr[index[attribute]][j:j+size])[0])
				if m>0.5:
					#print np.corrcoef(( arr[index[indexkey]] ,arr[index[secondIndexKey]]))
					farr.append('28SensorValue')
					sarr.append(arr[attribute-1].dtype.names[attribute-1])
					corr.append(m)
					xarr.append(i)
					yarr.append(j)
				#print i , j , m
		temp=self.topten(farr,sarr,corr,xarr,yarr)
		for i in range (0,len(temp)):
			outtemp.append(temp[i])
		return outtemp
			
	def printer(self,temp,size,shift):
		col="CGMSlidingCorrelationFinal.csv"
		crf= csv.writer(open(col, "wb"))
		for u in range(0,len(temp)):
			crf.writerow([temp[u][0],temp[u][1],temp[u][2],temp[u][3],temp[u][4],size,shift])
		
sl=cgmslidingcorr()
arr,index=sl.reader("MYFILE.csv")
outtemp=[]
for f in range(2,28):
	outtemp=(sl.slider(2000,10,f,arr,index,outtemp))
#print outtemp	
sl.printer(outtemp,2000,10)					
				
	
	