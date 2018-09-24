# spring-boot-pi
Switching GPIO through rest interface using pi4j, wiringPi and springBoot

For wiring see: http://pi4j.com/pins/model-3b-plus-rev1.html

Using springboot 2 did not work, had toi revert to the 1.last version.

Since I am running this on a Raspberry Pi 3b+ i needed to use the development version of WiringPi: https://github.com/WiringPi/WiringPi

Steps:
* Get latest image of Raspbian
* Put image onn SD card
* Turn on SSH
* Install Java
* Install WiringPi 
  * install Git
  * clone WiringPi project
  * build
* Build Javaproject
* SFTP project to Raspberry Pi
* Run
