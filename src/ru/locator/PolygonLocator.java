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
		 * Центр полигона
		 */
		public Point center;
		/**
		 * Локализуемая точка
		 */
		public Point point;

		protected Sector lastSector;

		public PolygonLocator(ArrayList<Point> polygon, Point center)
		{
				this.setPoint(point);
				this.setPolygon(polygon);
		}


		public boolean localize(Point point, boolean useAdaptive)
		{
				this.setPoint(point);
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

		protected boolean inFrontierSectors()
		{
				this.lastSector = new Sector(
								this.getCenter(),
								this.getPolygon().get(this.getPolygon().size() - 2),
								this.getPolygon().get(1)
				);
				return this.lastSector.isInside(this.getPoint());
		}

		public void setPolygon(ArrayList<Point> polygon)
		{
				this.polygon = polygon;
		}

		public void setPoint(Point point)
		{
				this.point = point;
		}

		public void setCenter(Point center)
		{
				this.center = center;
		}

		public ArrayList<Point> getPolygon()
		{
				return polygon;
		}

		public Point getPoint()
		{
				return point;
		}

		public Point getCenter()
		{
				return center;
		}
}
