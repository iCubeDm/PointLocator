import ru.locator.core.IntersectionHelper;
import ru.locator.core.Point;
import ru.locator.core.Segment;

/**
 * Created by dymsp
 */
public class Main
{
		public static void main(String[] args)
		{
				Point A = new Point(-5, 1);
				Point B = new Point(5, 1);
				Point C = new Point(1, -5);
				Point D = new Point(1, 5);

				Segment AB = new Segment(A, B);
				Segment CD = new Segment(C, D);

				System.out.println(IntersectionHelper.intersect(AB, CD));
		}
}
