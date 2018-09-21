public class Calculate {

    public static void main(String[] args) {

        Dim dim = Dim.NULL;
        ShapeType shapeType = ShapeType.REGULAR;
        Shape shape = Shape.NULL;
        int arguments;
        double answer = 0;

        Double a = 0.0, b = 0.0, c = 0.0;

        try {
            dim = Dim.valueOf(args[0].toUpperCase());
            shapeType = ShapeType.valueOf(args[1].toUpperCase());
            shape = Shape.valueOf(args[2].toUpperCase());
        }catch(IllegalArgumentException Enum){
            System.out.println("Your Input Is Non-Compliant");
        }

        arguments = args.length;
        try {
            switch (arguments) {

                case 4:
                    a = Double.valueOf(args[3]);
                    break;
                case 5:
                    b = Double.valueOf(args[4]);
                    break;
                case 6:
                    c = Double.valueOf(args[5]);
                    break;
            }
        }catch(Exception e){
            //e.printStackTrace();
            System.out.println("Argument 4,5 or 6 Was Not Properly Assigned");
        }
        if(shape != Shape.NULL) {
            if (dim == Dim.AREA) {
                if (shape == Shape.TRIANGLE) {
                    Area body = new Triangle(a, b, c);
                    answer = body.getArea();
                } else if (shape == Shape.SQUARE) {
                    Area body = new Square(a, b);
                    answer = body.getArea();
                } else if (shape == Shape.CIRCLE) {
                    Area body = new Circle(a);
                    answer = body.getArea();
                } else if (shape == Shape.NULL) {
                    System.out.println("Argument 3 'shape' Was Not Properly Assigned");
                }


            } else if (dim == Dim.VOLUME) {
                if (shape == Shape.BOX) {
                    Volume body = new Box(a,b,c);
                    answer = body.getVolume();
                } else if (shape == Shape.SPHERE) {
                    Volume body = new Sphere(a);
                    answer = body.getVolume();
                } else if (shape == Shape.PYRAMID) {
                    Volume body = new Pyramid(a,b);
                    answer = body.getVolume();
                }

            } else if (dim == Dim.NULL) {
                System.out.println("Argument 1 'dim' Was Not Properly Assigned");
            }
        }
        if(answer != 0) {
            System.out.println(answer);
        }else{
            System.out.println("Your Input Is Non-Compliant");
        }
    }
}
