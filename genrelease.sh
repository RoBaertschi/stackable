#!/bin/bash
# Generate a Markdown change log of pull requests from commits between two tags
# Author: Russell Heimlich; Modified by Robin Bärtschi
# URL: https://gist.github.com/kingkool68/09a201a35c83e43af08fcbacee5c315a

git tag $1

# Repo URL to base links off of
REPOSITORY_URL=https://github.com/RoBaertschi/stackable

# Get a list of all tags in reverse order
# Assumes the tags are in version format like v1.2.3
GIT_TAGS=$(git tag -l --sort=-version:refname)

# Make the tags an array
# shellcheck disable=SC2206
TAGS=($GIT_TAGS)
LATEST_TAG=${TAGS[0]}
PREVIOUS_TAG=${TAGS[1]}


# Store our changelog in a variable to be saved to a file at the end
MARKDOWN="Full Changelog: $REPOSITORY_URL/compare/$PREVIOUS_TAG...$LATEST_TAG"
MARKDOWN+='\n'

MARKDOWN+="$(git log $PREVIOUS_TAG..$LATEST_TAG --oneline)"

echo -e "$MARKDOWN" > changelog.md

git add changelog.md

git commit -m "Finalizing Release $1"


