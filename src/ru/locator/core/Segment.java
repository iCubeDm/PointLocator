package ru.locator.core;

/**
 * Created by iCubeDm
 */
public class Segment
{
		protected Point startPoint;
		protected Point endPoint;

		public Segment(Point startPoint, Point endPoint)
		{
				this.setStartPoint(startPoint);
				this.setEndPoint(endPoint);
		}

		/**
		 * Возвращает длину отрезка
		 *
		 * @return double
		 */
		public double getLength()
		{
				return this.getStartPoint().getDistanceToPoint(this.getEndPoint());
		}

		/**
		 * Возвращает проекцию отрезка на ось ОХ
		 *
		 * @return Segment
		 */
		public Segment getOXProjection()
		{
				return new Segment(new Point(this.getStartPoint().getX(), 0), new Point(this.getEndPoint().getX(), 0));
		}

		/**
		 * Возвращает проекцию отрезка на ось ОY
		 *
		 * @return Segment
		 */
		public Segment getOYProjection()
		{
				return new Segment(new Point(0, this.getStartPoint().getY()), new Point(0, this.getEndPoint().getY()));
		}

		public void setStartPoint(Point startPoint)
		{
				this.startPoint = startPoint;
		}

		public void setEndPoint(Point endPoint)
		{
				this.endPoint = endPoint;
		}

		public Point getStartPoint()
		{
				return startPoint;
		}

		public Point getEndPoint()
		{
				return endPoint;
		}
}
