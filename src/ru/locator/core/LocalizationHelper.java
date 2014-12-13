package ru.locator.core;

/**
 * Created by dymsp
 */
public class LocalizationHelper
{
		/*
		Для географических координат:
		LAT - широта = Y
		LNG - долгота = X
		*/

		/**
		 * Пусть заданы три точки A, B и C.
		 * Предположим, что мы смотрим из точки A в точку B.
		 * Где при этом окажется точка C — справа или слева относительно направления нашего взгляда?
		 * Ответить на этот вопрос можно с помощью векторного произведения векторов a=AB и b=BC,
		 * точнее с помощью z-координаты такого произведения, которая вычисляется по простой формуле z=a(x)b(y)-a(y)b(x).
		 * Если z>0, то искомый поворот левый, если z<0 — то правый.
		 * Если же монета упала на ребро z=0, то три точки лежат на одной прямой (говорят, что векторы a и b коллинеарны).
		 *
		 * @param currentPoint точка C
		 * @param segmentBegin точка A
		 * @param segmentEnd   точка B
		 * @return >0 - левый поворот, 0 - лежит на, <0 - правый поворот
		 * @link http://habrahabr.ru/post/144571/
		 */
		public static Double rotate(Point currentPoint, Point segmentBegin, Point segmentEnd)
		{
				return (segmentBegin.getX() - segmentEnd.getX()) * (currentPoint.getY() - segmentEnd.getY()) -
								(segmentEnd.getY() - segmentBegin.getY()) * (currentPoint.getX() - segmentEnd.getX());
		}

		/**
		 * Чтобы проверить, располагаются ли точки C и D по разные стороны относительно отрезка (вектора) AB,
		 * надо посмотреть на направления поворотов rotate(A,B,C) и rotate(A,B,D).
		 * Если знаки этих выражений различны, то прямая AB пересекает отрезок CD (причем во внутренней точке).
		 * Знаки двух чисел различны, в том и только в том случае, когда их произведение отрицательно.
		 * Следовательно, критерием пересечения отрезков AB и CD является отрицательность двух выражений:
		 * rotate(A,B,C)*rotate(A,B,D) и rotate(C,D,A)*rotate(C,D,B).
		 * Если заменить строгую отрицательность на неположительность,
		 * то сможем отлавливать пересечение и в концевых точках отрезков.
		 *
		 * @param firstSegment  отрезок AB
		 * @param secondSegment отрезок CD
		 * @return лежат ли С и D по разные стороны AB
		 * @link http://habrahabr.ru/post/144571/
		 * 42:8
		 */
		public static boolean intersect(Segment firstSegment, Segment secondSegment)
		{
				return (rotate(firstSegment.getStartPoint(), firstSegment.getEndPoint(), secondSegment.getStartPoint())
								* rotate(firstSegment.getStartPoint(), firstSegment.getEndPoint(), secondSegment.getEndPoint()) <= 0
								&& (rotate(secondSegment.getStartPoint(), secondSegment.getEndPoint(), firstSegment.getStartPoint())
								* rotate(secondSegment.getStartPoint(), secondSegment.getEndPoint(), firstSegment.getEndPoint())) < 0);
		}
}
