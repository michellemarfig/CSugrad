//Written by: Michelle Martinez-Figueroa
// CS 273
// March 8, 2019
// Lab 6 - Displaying Tempreature and Humidity on DHT11 display
// take a string, compare it, and send back ascii value

/*  This is a unified sketch product that utlizes the DHT11 master libraries,
     the TM1637 and the Ardufruit libraries.

     This was taken from the examples provided from each of the libraries and then
     incorporated

     This project reads data from the DHT11 and puts the values onto a I2C backpack 4x7 segment
     display called a TM 1637.

     The program reads values from the DHT, then outputs alternating values on teh
     display for temperature and Humidity.

     This also prints to the default serial monitor for QA purposes

     Shaun Cooper
     February 2017

 *   */

// DHT Temperature & Humidity Sensor
// Unified Sensor Library Example
// Written by Tony DiCola for Adafruit Industries
// Released under an MIT license.

// Depends on the following Arduino libraries:
// - Adafruit Unified Sensor Library: https://github.com/adafruit/Adafruit_Sensor
// - DHT Sensor Library: https://github.com/adafruit/DHT-sensor-library

extern char data[];
extern char inbound;
extern char result;

extern "C" {
  void display_symbol();
}

extern "C" {
  void decode();
}


#include <Adafruit_Sensor.h>
#include <DHT.h>
#include <DHT_U.h>
#include <Arduino.h>
#include <TM1637Display.h>

// Module connection pins (Digital Pins) for TM 1637
#define CLK 9
#define DIO 8
#define DHTPIN            2         // Pin which is connected to the DHT sensor

//TM1637Display display(CLK, DIO); // create a display object

// Uncomment the type of sensor in use:
#define DHTTYPE           DHT11     // DHT 11 
//#define DHTTYPE           DHT22     // DHT 22 (AM2302)
//#define DHTTYPE           DHT21     // DHT 21 (AM2301)

// See guide for details on sensor wiring and usage:
//   https://learn.adafruit.com/dht/overview

DHT_Unified dht(DHTPIN, DHTTYPE);

// The amount of time (in milliseconds) between tests
#define TEST_DELAY   2000

const uint8_t SEG_DONE[] = {
  SEG_B | SEG_C | SEG_D | SEG_E | SEG_G,           // d
  SEG_A | SEG_B | SEG_C | SEG_D | SEG_E | SEG_F,   // O
  SEG_C | SEG_E | SEG_G,                           // n
  SEG_A | SEG_D | SEG_E | SEG_F | SEG_G            // E
};

const uint8_t H = SEG_B | SEG_C | SEG_E | SEG_F | SEG_G; // H
const uint8_t T =  SEG_D | SEG_E | SEG_F | SEG_G; // t
const uint8_t BLANK = 0;


uint32_t delayMS;

void setup() {
  Serial.begin(9600);
  // Initialize device.
  dht.begin();
  Serial.println("DHTxx Unified Sensor Example");
  // Print temperature sensor details.
  sensor_t sensor;
  dht.temperature().getSensor(&sensor);
  Serial.println("------------------------------------");
  Serial.println("Temperature");
  Serial.print  ("Sensor:       "); Serial.println(sensor.name);
  Serial.print  ("Driver Ver:   "); Serial.println(sensor.version);
  Serial.print  ("Unique ID:    "); Serial.println(sensor.sensor_id);
  Serial.print  ("Max Value:    "); Serial.print(sensor.max_value); Serial.println(" *C");
  Serial.print  ("Min Value:    "); Serial.print(sensor.min_value); Serial.println(" *C");
  Serial.print  ("Resolution:   "); Serial.print(sensor.resolution); Serial.println(" *C");
  Serial.println("------------------------------------");
  // Print humidity sensor details.
  dht.humidity().getSensor(&sensor);
  Serial.println("------------------------------------");
  Serial.println("Humidity");
  Serial.print  ("Sensor:       "); Serial.println(sensor.name);
  Serial.print  ("Driver Ver:   "); Serial.println(sensor.version);
  Serial.print  ("Unique ID:    "); Serial.println(sensor.sensor_id);
  Serial.print  ("Max Value:    "); Serial.print(sensor.max_value); Serial.println("%");
  Serial.print  ("Min Value:    "); Serial.print(sensor.min_value); Serial.println("%");
  Serial.print  ("Resolution:   "); Serial.print(sensor.resolution); Serial.println("%");
  Serial.println("------------------------------------");
  // Set delay between sensor readings based on sensor details.
  delayMS = sensor.min_delay / 1000;
}

void loop() {
  int t1, t2;
  int h1, h2;
  // Delay between measurements.
  delay(delayMS);
  // Get temperature event and print its value.
  sensors_event_t event;
  dht.temperature().getEvent(&event);
  if (isnan(event.temperature)) {
    Serial.println("Error reading temperature!");
  }
  else {
    Serial.print("Temperature: ");
    Serial.print(event.temperature);
    Serial.println(" *F");
    t1 = event.temperature / 10;
    t2 = event.temperature;
    t2 = t2 % 10;
    Serial.println(t1);
    Serial.println(t2);
  }
  // Get humidity event and print its value.
  dht.humidity().getEvent(&event);
  if (isnan(event.relative_humidity)) {
    Serial.println("Error reading humidity!");

  }
  else {
    Serial.print("Humidity: ");
    Serial.print(event.relative_humidity);
    Serial.println("%");
    h1 = event.relative_humidity / 10;
    h2 = event.relative_humidity;
    h2 = h2 % 10;
    Serial.println(h1);
    Serial.println(h2);
  }

//  display.setBrightness(0x0f);
  // Selectively set different digits
  
  //  This is my humidity ***************************
  data[0] = H;
  data[1] = BLANK;

//Here to display data[2], call decode to get correct binary pattern to draw the digit on the correct pins
  inbound = h1;
  decode();
  data[2] = result; //LAB6 this line is changed

  inbound = h2;
  decode();
  data[3] = result; // LAB6 this line is changed
  display_symbol();
  delay(TEST_DELAY);

  //This is my temperature ***************************
    data[0] = T;
    data[1] = BLANK;

    inbound = t1;
    decode();
    data[2] = result;
  
    inbound = t2;
    decode();
    data[3] = result;
    display_symbol();
    delay(TEST_DELAY);


  // Heres done *************************************
  data[0] = SEG_DONE[0];
  data[1] = SEG_DONE[1];
  data[2] = SEG_DONE[2];
  data[3] = SEG_DONE[3];
  display_symbol();
  delay(TEST_DELAY);
}
