package ru.locator.core;

/**
 * Created by iCubeDm
 */
public class Point
{
		protected double x;
		protected double y;

		/**
		 * @param x absciss
		 * @param y ordinate
		 */
		public Point(double x, double y)
		{
				this.setX(x);
				this.setY(y);
		}

		/**
		 * @param point дистанция до входящей точки
		 * @return double
		 */
		public double getDistanceToPoint(Point point)
		{
				return Math.sqrt(Math.pow(point.getX() - this.getX(), 2) + Math.pow(point.getY() - this.getY(), 2));
		}

		public double getX()
		{
				return x;
		}

		public double getY()
		{
				return y;
		}

		public void setX(double x)
		{
				this.x = x;
		}

		public void setY(double y)
		{
				this.y = y;
		}
}
