package ru.locator;

import ru.locator.core.Point;
import ru.locator.core.Sector;

import java.util.ArrayList;

/**
 * Created by dymsp
 */
public class PolygonLocator
{
		/**
		 * Замкнутый многоугольник в котором должна быть локализованна точка
		 */
		public ArrayList<Point> polygon;
		/**
		 * Локализуемая точка
		 */
		public Point point;

		protected Sector lastSector;

		public PolygonLocator(ArrayList<Point> polygon, Point point)
		{
				this.setPoint(point);
				this.setPolygon(polygon);
		}


		public boolean localize(boolean useAdaptive)
		{
				return useAdaptive ? this.adaptive() : this.binary();
		}

		protected boolean adaptive()
		{

				return true;
		}

		protected boolean binary()
		{

				return true;
		}

		public void setPolygon(ArrayList<Point> polygon)
		{
				this.polygon = polygon;
		}

		public void setPoint(Point point)
		{
				this.point = point;
		}

		public ArrayList<Point> getPolygon()
		{
				return polygon;
		}

		public Point getPoint()
		{
				return point;
		}
}
