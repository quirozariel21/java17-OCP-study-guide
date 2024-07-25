public class ExceptionHerencia {

    public static void main(String args[]) {
        try {
            if( args.length == 0)
                m2();
            else
                m3();
/*		} catch(Exception e) {
    COMPILE (1)
		}
*/
/*
		} catch(NewException | AnotherException e) {
    COMPILE (2)
		}
*/
/*
		} catch(NewException n) {
	COMPILE (3)
		} catch(AnotherException a) {

		}
*/

        } catch(AnotherException n) {
            //	COMPILE (4)
        } catch(NewException a) {

        }
    }


    public static void m2() throws NewException {
        throw new NewException();
    }

    public static void m3() throws AnotherException {
        throw new AnotherException();
    }
}

class NewException extends Exception {

}

class AnotherException extends Exception {

}