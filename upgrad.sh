#!/bin/bash
echo "Running imdb automation"
java -cp target/BotAutomation/BotAutomation.jar com.gupshup.framework.Start
if [ $? -eq 0 ]
then
echo "Sucessfully Completed"
else
echo "Failed while running jar"
fi