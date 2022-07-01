# Asystent elektronika / Electronic's assistant
## Description

Application had its first release around 2006 as freeware application, and it was developed in Delphi back then.
Then I've rewritten it to Java around 2010-2011, basically to learn Java and OOP.
I added some functionality over time, but then I started full-time job as a software developer,
and I hadn't much time for it. It wasn't maintained since 2014.
I was convinced that the source code was long gone, but lately I've found it on an old HDD.
Current release aims to refresh it a little and release it as open-source.

Please don't judge the code. I was around 18 years old when I was writing most of the classes
(and starting to learn Java) so they need a lot of refactoring (at least).

When application was in active development, it had its small user base in Poland.
I release it with thought that maybe someone can still make use of it?

## Current state

Currently, application is very slightly refactored. I've added resources to enable translations,
but there are still a lot of sings of form builder and very "dirty" code.
Application has very simple plugin loader and one plugin, that contains most modules from its last release from 2014.
I've deleted modules that were not useful anymore (for example very outdated microcontroller database).

## Features

- Calculate resistor for LED
- Calculate combined resistance of up to 10 resistors
- Calculate Ohm's law (voltage, current, power)
- Calculate resistive voltage divider
- Calculate radiator parameters for IC
- Calculate air cored coil inductance
- Find closest value in E series
- Convert frequency and period
- Convert watts and dBm
- Convert order of magnitude (pico, nano, kilo, mega, etc.)
- Convert numerical systems (bin, oct, dec, hex)
- Decode bar codes (resistors, capacitors and chokes)
- Decode MIL code
- Calculate values for simple opamp circuits
- Calculate resistor for LM3xx voltage stabilizer
- Calculate element values for NE555 oscillators
- Calculate timer values for AVR microcontrollers (old series like ATMega 8, 16, 32, etc.)
- Calculate I2C (TWI) values for AVR microcontrollers (old series like ATMega 8, 16, 32, etc.)
- Calculate UART/USART values for AVR microcontrollers (old series like ATMega 8, 16, 32, etc.)
- Generate bitmap fonts
- Generate characters for seven segment display
- Generate images for displays (monochromatic and color)
- Generate custom characters for HD44780 display

## TODO list
- Refactoring
- Automatic update module
- New functionalities (?)
    - E series in led resistor, voltage divider, ...
    - 7 segment: 32 bit, add letters
    - Image generator: marlin images?, window resize...
    - Bitmap font: missing functions (greyed out)