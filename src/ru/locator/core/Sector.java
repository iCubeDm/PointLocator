package ru.locator.core;

/**
 * Created by dymsp
 */
public class Sector
{
		public Point center;
		public Point right;
		public Point left;

		public Sector(Point center, Point right, Point left)
		{
				this.setCenter(center);
				this.setLeft(left);
				this.setRight(right);
		}

		/**
		 * Проверяет попадение входящей точки в сектор
		 * @param point point
		 * @return boolean
		 */
		public boolean isInside(Point point)
		{
				return LocalizationHelper.rotate(this.getCenter(), this.getRight(), point) < 0
								|| LocalizationHelper.rotate(this.getCenter(), this.getLeft(), point) > 0;
		}

		public double radius()
		{
				return new Segment(this.getCenter(), this.getRight()).length();
		}

		/**
		 * Возвращает длину дуги
		 * @return double
		 */
		public double arcLength()
		{
				return 2 * Math.PI * this.radius() * (this.angle() / 360);
		}

		/**
		 * Возвращает длину окружности
		 * @return double
		 */
		public double circleLenght()
		{
				return 2 * Math.PI * this.radius() * (360 / this.angle());
		}

		/**
		 * Возвращает угол сектора.
		 * Вычисляется по теореме косинусов, с учетом того, что правая и левая точки лежат на окружности, содержащей сектор.
		 * @return double
		 */
		public double angle()
		{
				Segment rc = new Segment(this.getRight(), this.getCenter());
				Segment cl = new Segment(this.getCenter(), this.getLeft());
				Segment rl = new Segment(this.getRight(), this.getLeft());

				double dividend = Math.pow(rc.length(), 2) + Math.pow(cl.length(), 2) - Math.pow(rl.length(), 2);
				double divider = 2 * rc.length() * cl.length();
				return Math.acos(dividend / divider);
		}

		public void setCenter(Point center)
		{
				this.center = center;
		}

		public void setRight(Point right)
		{
				this.right = right;
		}

		public void setLeft(Point left)
		{
				this.left = left;
		}

		public Point getCenter()
		{
				return center;
		}

		public Point getRight()
		{
				return right;
		}

		public Point getLeft()
		{
				return left;
		}
}
