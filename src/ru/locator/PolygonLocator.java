package ru.locator;

import ru.locator.core.Point;
import ru.locator.core.Sector;

import java.util.ArrayList;
import java.util.Map;

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
				this.setCenter(center);
				this.setPoint(point);
				this.setPolygon(polygon);
		}


		public Sector localize(Point point, boolean useAdaptive)
		{
				this.setPoint(point);
				this.lastSector = useAdaptive ? this.standartLocating() : this.adaptiveLocating();

				return this.lastSector;
		}

		protected Sector adaptiveLocating()
		{
				return standartLocating();
		}

		protected Sector standartLocating()
		{
				if (this.inFrontierSectors()) {
						return this.checkSectorByPoints(this.polygon.get(1), this.polygon.get(0)) ?
										new Sector(this.center, this.polygon.get(1), this.polygon.get(0)) :
										new Sector(this.polygon.get(0), this.center, this.polygon.get(this.polygon.size() - 1));
				}

				Point min = this.polygon.get(1);
				Point max = this.polygon.get(this.polygon.size() - 1);

				while (this.polygon.indexOf(max) - this.polygon.indexOf(min) > 1) {
						Point split =
										this.polygon.get((int) (this.polygon.indexOf(min) +
														Math.ceil((this.polygon.indexOf(max) - this.polygon.indexOf(min)) / 2)));
						if (this.checkSectorByPoints(min, split)) {
								max = split;
						} else {
								min = split;
						}
				}

				return new Sector(center, max, min);
		}

		public boolean checkSectorByPoints(Point right, Point left)
		{
				Sector sector = new Sector(this.getCenter(), right, left);
				return sector.isInside(this.getPoint());
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
