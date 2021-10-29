from http.client import error
from django.shortcuts import render
from django.http import JsonResponse

from rest_framework.decorators import api_view
from rest_framework.response import Response

# Create your views here.

@api_view(['GET']) #must be set for EVERY single view
def getRoutes(request):
  routes = [
    "/main",
    
    "/intro",

    "/fake/<userid>",

    "/bloothhound",
    "/bloothhound/scores",
    "/bloothhound/scores/<score>",

    "/about/stack",
    "/about/me",
    "/about/contact"
  ]

  return Response(routes)

@api_view(['GET'])
def getMain(request):

  print('Here\'s your GET request to /main:', request)

  test = [
    "one",
    "two",
    "three",
  ]

  return Response(test)

@api_view(['GET'])
def getFakeUsers(request, userid):
  users = {
    '0': 'Jorge',
    '1': 'David',
    '2': 'Sunny',
    '3': 'Sean',
    '4': 'Tim',
  }

  try:
    return Response(users[userid])
  except KeyError:
    return Response("Error: user with specified id does not exist...")

