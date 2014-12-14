import ru.locator.PolygonLocator;
import ru.locator.core.Point;
import java.util.ArrayList;

/**
 * Created by dymsp
 */
public class Main
{
		public static void main(String[] args)
		{
				ArrayList<Point> polygon = new ArrayList<Point>();
				polygon.add(new Point(0, -8));
				polygon.add(new Point(-6, -6));
				polygon.add(new Point(-8, 0));
				polygon.add(new Point(-6, 6));
				polygon.add(new Point(0, 8));
				polygon.add(new Point(6, 6));
				polygon.add(new Point(8, 0));
				polygon.add(new Point(6, -6));

				Point A = new Point(2, 3);
				Point B = new Point(8, 4);
				Point C = new Point(-8, -4);
				Point D = new Point(-4, 3);

				PolygonLocator locator = new PolygonLocator(polygon, new Point(0, 0));


				System.out.println(locator.localize(A, false).toString());
				System.out.println(locator.localize(B, false).toString());
				System.out.println(locator.localize(C, false).toString());
				System.out.println(locator.localize(D, false).toString());
		}
}
