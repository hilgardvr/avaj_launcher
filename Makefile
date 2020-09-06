# **************************************************************************** #
#                                                                              #
#                                                         :::      ::::::::    #
#    Makefile                                           :+:      :+:    :+:    #
#                                                     +:+ +:+         +:+      #
#    By: gvan-roo <marvin@42.fr>                    +#+  +:+       +#+         #
#                                                 +#+#+#+#+#+   +#+            #
#    Created: 2018/06/03 08:40:09 by gvan-roo          #+#    #+#              #
#    Updated: 2018/06/25 08:40:29 by gvan-roo         ###   ########.fr        #
#                                                                              #
# **************************************************************************** #

all:
	mkdir -p bin
	find ./com/gmail/hilgardvr/avaj_launcher/src/ -name "*.java" > sources.txt
	javac -d bin @sources.txt

clean:
	rm -r bin/*

fclean:
	make clean
	rmdir bin
	rm sources.txt
	rm simulation.txt

make re:
	make fclean
	make

run:
	java -cp bin com.gmail.hilgardvr.avaj_launcher.src.aircraft.AircraftFactory scenario.txt
