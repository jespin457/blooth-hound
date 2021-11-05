from django.urls import path
from . import views

urlpatterns = [
  path('routes/', views.getRoutes, name="routes"),
  path('main/', views.getMain, name="main"),
  path('fakeusers/<str:userid>', views.getFakeUsers, name="fakeusers"),
]