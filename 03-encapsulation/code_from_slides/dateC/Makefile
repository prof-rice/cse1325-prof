info:
	@echo
	@printf 'Type e.g., "make 01_enum" to create program "01_enum"\n'
	@printf 'Type       "make all"     to create every program\n'
	@printf 'Type       "make clean"   to delete every program\n\n'

01_enum: 01_enum.c
	-$(CC) $(CCFLAGS) -o 01_enum 01_enum.c
	@printf "Now type ./01_enum to execute the result\n\n"

02_enum_to_string: 02_enum_to_string.c
	-$(CC) $(CCFLAGS) -o 02_enum_to_string 02_enum_to_string.c
	@printf "Now type ./02_enum_to_string to execute the result\n\n"

03_enum_to_string_reprise: 03_enum_to_string_reprise.c
	-$(CC) $(CCFLAGS) -o 03_enum_to_string_reprise 03_enum_to_string_reprise.c
	@printf "Now type ./03_enum_to_string_reprise to execute the result\n\n"

04_day_and_year: 04_day_and_year.c
	-$(CC) $(CCFLAGS) -o 04_day_and_year 04_day_and_year.c
	@printf "Now type ./04_day_and_year to execute the result\n\n"

05_date_to_string: 05_date_to_string.c
	-$(CC) $(CCFLAGS) -o 05_date_to_string 05_date_to_string.c
	@printf "Now type ./05_date_to_string to execute the result\n\n"

06_more_dates: 06_more_dates.c
	-$(CC) $(CCFLAGS) -o 06_more_dates 06_more_dates.c
	@printf "Now type ./06_more_dates to execute the result\n\n"

07_data_validation: 07_data_validation.c
	-$(CC) $(CCFLAGS) -o 07_data_validation 07_data_validation.c
	@printf "Now type ./07_data_validation to execute the result\n\n"

all:  01_enum 02_enum_to_string 03_enum_to_string_reprise 04_day_and_year 05_date_to_string 06_more_dates 07_data_validation

clean:
	rm -f *.o *.gch a.out  01_enum 02_enum_to_string 03_enum_to_string_reprise 04_day_and_year 05_date_to_string 06_more_dates 07_data_validation

