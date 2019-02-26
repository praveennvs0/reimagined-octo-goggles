
public class Intbox {
        int i;
        public Intbox(int i) 
        
        { this.i = i; 
        
        }

        // equals other IntBoxes that store the same int value.
        @Override
        public boolean equals(Object o) {
            Intbox other = (Intbox) o;
            return this.i == other.i;
        }
    }





    
       