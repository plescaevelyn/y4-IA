int timer = 100;
boolean circuitOK;
int rez;
void setup() {
  pinMode(7, OUTPUT);   // a 
  pinMode(6, OUTPUT);   // b
  pinMode(5, OUTPUT);   // c

  pinMode(2, INPUT);   // z (test result)

  Serial.begin(9600);    //start serial communication @9600 bps
  }

void loop() {
      /* 
      
      test the circuit with the following test set
      011->0,101->0,111->1
      
      */
    
      circuitOK = true;
      digitalWrite(4, LOW);
      for (int thisTest = 1; thisTest < 4; thisTest++){
          if (thisTest == 1){
            //write values on input lines
            digitalWrite(7, LOW); //a line
            digitalWrite(6, HIGH); //b line
            digitalWrite(5, HIGH); //c line
            
            delay(timer);

            //read z line value
            rez = digitalRead(2); 
            if (rez != 0){
              circuitOK = false;
            } else {
              Serial.print("Testul 1 merge!\n");
            }
          }

          if (thisTest == 2){
            //write values on input lines
            digitalWrite(7, HIGH); //a line
            digitalWrite(6, LOW); //b line
            digitalWrite(5, HIGH); //c line
            
            delay(timer);
            
            rez = digitalRead(2); //read z line
            if (rez != 0){
              circuitOK = false;
            } else {
              Serial.print("Testul 2 merge!\n");
            }
          }

          if (thisTest == 3){
            //write values on input lines
            digitalWrite(7, HIGH); //a line
            digitalWrite(6, HIGH); //b line
            digitalWrite(5, HIGH); //c line
            
            delay(timer);
            
            rez = digitalRead(2); // read z line
            if (rez != 1){
              circuitOK = false;
            } else {
              Serial.print("Testul 3 merge!\n");
            }
          }
      }

      if (!circuitOK){
        Serial.print("Nu merge! :( \n");
      }

      Serial.print("\n");
}
